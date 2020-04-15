import requests
link = "http://140.122.185.173:8080/oracle/"
cipher = "1234567812345678123456781234567812345678123456781234567812345678"
# cipher = "44128774545"
print(len(cipher))
r = requests.get(link+cipher)

if r.status_code == requests.codes.ok:
	print (r.text)
	
else:
	print( "Connection Error" )
	
