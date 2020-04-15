import requests
import string
def test(a):
	c = "http://140.122.185.173:8080/oracle/"
	d = c + a
	r = requests.get(d)

	if r.status_code == requests.codes.ok:
		# print (r.text)
		return r.text
	else:
		print( "Connection Error" )
		return 0

# c = "http://140.122.185.173:8080/oracle/"
b = "0123456789abcdef0123456789abcdef462f0aec8f910e6b5daf6c47947de80c954a8b97fa9e58780f8298c6d06c05de0ab8b4d1a0bc03cf7c8ba306360a4f13725bc1e1021f34885a4c5349155c6ab91c9a22110d07dbc3f150672aeeb09b95baa2f7ea8b9b04644313c7787891f5884b4366499578d84631e0a488c63d7198bde5d0f8737ce6d6964da64bc674eadf9056091bbe674d781fe835384b296622643a7bd79c6d1c7f06185a26d5c81b25873d88850b6f79ff6865dfbc5c9a0e8ec000bf26daf8fe54a801fc11e0e68fed700c7bfef81206d028dfbef3d0311cb1"

n = ["0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"]
tex = []	#字碼表
for i in range(len(n)):
	for j in range(len(n)):
		temp = n[i]+n[j]
		tex.append(temp)
		
word = []
for i in b:
	word.append(i)
# print(word)
q = []		#拆解過的密文
w = ""
for i in range(14):
	w = ""
	for j in range(32):
		w = w +word[0]
		del word[0]
	q.append(w)	

testone = ""
# print(test(testone+testone))
# print (q[1])
# e =""
# for i in range(len(tex)):
# 	e = testone+tex[i]+"4a7507f6ccb88d31553902ebc9b49a"
# 	t = e + q[1]
# 	if(test(t)=="valid"):
# 		print(e)


	
list = ["8a","a4","d9","fb","12","29","45","21","9d","a8","dc","e6","17","65","5a","4c"]
d = list[::-1]
# print(d)
temp = []
for i in q[0]:
	temp.append(i)

# print(temp)
qone = []
for i in range(16):
	w = ""
	for j in range(2):
		w =w+temp[0]
		del temp[0]
	qone.append(w)

out = []
for i in range(len(d)):
	xor = int(d[i],16)^int(qone[i],16)
	out.append(hex(xor))

print(out)
ans = ""
for i in range(len(out)):
	ans = ans + (chr(int(out[i],16)))

print (ans)