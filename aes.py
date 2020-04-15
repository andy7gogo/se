# -*- coding: utf-8 -*-
import requests
import base64
url = "http://140.122.185.173:8080/oracle/0123456789abcdef0123456789abcdef462f0aec8f910e6b5daf6c47947de80c954a8b97fa9e58780f8298c6d06c05de0ab8b4d1a0bc03cf7c8ba306360a4f13725bc1e1021f34885a4c5349155c6ab91c9a22110d07dbc3f150672aeeb09b95baa2f7ea8b9b04644313c7787891f5884b4366499578d84631e0a488c63d7198bde5d0f8737ce6d6964da64bc674eadf9056091bbe674d781fe835384b296622643a7bd79c6d1c7f06185a26d5c81b25873d88850b6f79ff6865dfbc5c9a0e8ec000bf26daf8fe54a801fc11e0e68fed700c7bfef81206d028dfbef3d0311cb1"

N = 16

def inject_token(token):
    header = {"Cookie": "PHPSESSID=" + phpsession + ";token=" + token}
    result = requests.post(url, headers = header)
    return result

def xor(a, b):
    return "".join([chr(ord(a[i]) ^ ord(b[i % len(b)])) for i in xrange(len(a))])

def pad(string, N):
    l = len(string)
    if l != N:
        return string + chr(N - l) * (N - l)

def padding_oracle(N):
    get = ""
    for i in xrange(1, N+1):
        for j in xrange(0, 256):
            padding = xor(get, chr(i) * (i-1))
            c = chr(0) * (16-i) + chr(j) + padding
            result = inject_token(base64.b64encode(c))
            if "Error!" not in result.content:
                get = chr(j ^ i) + get
                break
    return get

while 1:
    session = requests.get(url).headers['Set-Cookie'].split(',')
    phpsession = session[0].split(";")[0][10:]
    print (phpsession)
    token = session[1][6:].replace("%3D", '=').replace("%2F", '/').replace("%2B", '+').decode('base64')
    middle1 = padding_oracle(N)
    print ("\n")
    if(len(middle1) + 1 == 16):
        for i in xrange(0, 256):
            middle = chr(i) + middle1
            print ("token:" + token)
            print ("middle:" + middle)
            plaintext = xor(middle,token)
            print ("plaintext:" + plaintext)
            des = pad('admin', N)
            tmp = ""
            print (des.encode("base64"))
            for i in xrange(16):
                tmp += chr(ord(token[i]) ^ ord(plaintext[i]) ^ ord(des[i]))
            print (tmp.encode('base64'))
            result = inject_token(base64.b64encode(tmp))
            if "You are admin!" in result.content:
                print (result.content)
                print ("success")
                exit()