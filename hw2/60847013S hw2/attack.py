import requests
def get(cipher):	#函式，帶入cipher為傳給伺服器的密文
	link = "http://140.122.185.173:8080/oracle/"
	send = link + cipher
	r = requests.get(send)

	if r.status_code == requests.codes.ok:
		return r.text 	#回傳伺服器的回應
	else:
		print("Error")
		return 0

def xor(a,b):	#計算XOR的函式
	x = int(a,16)^int(b,16)
	m = hex(x)[2:]
	if(len(m)==1):
		m = "0"+m
	return m

def midstr(middle,x):	#將算出來的的IV陣列變為字串
	temp = middle[::-1]
	s = ""
	for i in temp:
		s = s + xor(i,x)
	return s

def breakcipher(middle,text):	#將算出來的IV陣列與密文做XOR解出明文
	limit = 2
	cip = [text[i:i+limit] for i in range(0,len(text),limit)]
	mid = middle[::-1]
	word = ""
	for i in range(len(mid)):
		word = word + chr(int(xor(mid[i],cip[i]),16))

	return word

text = "0123456789abcdef0123456789abcdef462f0aec8f910e6b5daf6c47947de80c954a8b97fa9e58780f8298c6d06c05de0ab8b4d1a0bc03cf7c8ba306360a4f13725bc1e1021f34885a4c5349155c6ab91c9a22110d07dbc3f150672aeeb09b95baa2f7ea8b9b04644313c7787891f5884b4366499578d84631e0a488c63d7198bde5d0f8737ce6d6964da64bc674eadf9056091bbe674d781fe835384b296622643a7bd79c6d1c7f06185a26d5c81b25873d88850b6f79ff6865dfbc5c9a0e8ec000bf26daf8fe54a801fc11e0e68fed700c7bfef81206d028dfbef3d0311cb1"
#要破解的密文

asc = ["0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"] #創建出字碼表
asctable = []	#字碼表
for i in range(len(asc)):
	for j in range(len(asc)):
		temp = asc[i]+asc[j]
		asctable.append(temp)
# print (asctable) #裏頭存放[00,01,......,ff]

tsplit = []
for i in text:
	tsplit.append(i)
#將密文拆解為一個一個的字

limit = 32
textlist = [tsplit[i:i + limit] for i in range(0,len(tsplit),limit)]
text = []	#分割好的cipher 32為一組
for i in range(len(textlist)):
	s = ""
	for j in range(len(textlist[i])):
		s = s + textlist[i][j]
	text.append(s)
#將密文以長度32做切割
# print(text)

IV = ["000000000000000000000000000000","0000000000000000000000000000","00000000000000000000000000",
	"000000000000000000000000","0000000000000000000000","00000000000000000000","000000000000000000",
	"0000000000000000",	"00000000000000","000000000000","0000000000",
	"00000000","000000","0000","00",""]
#開始做padding oracle的IV設定

tryasc = ["01","02","03","04","05","06","07",
	"08","09","0a","0b","0c","0d","0e","0f","10"]
#最後一碼為0x01，倒數第二碼為0x02，存放這些嘗試的陣列

middle = []#將解出來的IV存放的陣列

#只做一個密文塊破解的for迴圈
# for j in range(len(IV)):
# 	for i in asctable:
# 		cipher = IV[j]+i+midstr(middle,tryasc[j])+text[2]
# 		if(get(cipher)=="valid"):
# 			print(i)
# 			m = xor(i,tryasc[j])
# 			middle.append(m)
# 			break

#將所有密文一次解完的for迴圈
for t in range(1,len(text),1):
	middle = []
	for j in range(len(IV)):
		for i in asctable:
			cipher = IV[j]+i+midstr(middle,tryasc[j])+text[t]
			if(get(cipher)=="valid"):
				# print(i)
				m = xor(i,tryasc[j])
				middle.append(m)
				break
	print(middle)
	print(breakcipher(middle,text[t-1]))

