a = 32
b = 65
c = a^b
# print(c)

s = "20"
i = int(s,16)


space = "8a"
A = "02"
w = int(space,16)^int(A,16)
# print(w)
W = hex(w)
print(W)

#8b [8a] 
#a6 [a4]  
#da [d9]
#ff [fb]
#17 [12]
#2f [29]
#42 [45]
#29 [21]
#94 [9d]
#a2 [a8]
#d7 [dc]
#ea [e6]
#1a [17]
#6b [65]
#55 [5a]
#5c [4c]
list = ["8a","a4","d9","fb","12","29","45","21","9d","a8","dc","e6","17","65","5a","4c"]
def p(list,A):
    s = []
    for i in range(len(list)):
        w = int(list[i],16) ^int(A,16)
        s.append(hex(w))
    d = s[::-1]
    print (d)

p(list,A)