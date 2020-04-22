def modInverse(a, m) : 
    a = a % m; 
    for x in range(1, m) : 
        if ((a * x) % m == 1) : 
            return x 
    return 0

print(modInverse(472,16651))

# print(62/4)
# print(6407%6407)

def computeGCD(x, y): 
  
   while(y): 
       x, y = y, x % y 
  
   return x 


a = 24
b = 22
print (computeGCD(a,b)) 
# print(a%b)

# def ext_eculid(a, b):
#     print('a = {0}, b = {1}'.format(a, b))
#     if b == 0:
#         print('Finally, {0} {1} {2}'.format(1, 0, a))
#         return 1, 0, a
#     else:
#         x, y, q = ext_eculid(b, a % b) # q = gcd(a, b) = gcd(b, a%b)
#         x, y = y, (x - (a//b)*y)
#         print('{0} {1} {2}'.format(x, y, q))
#         return x, y, q

# a=361
# b=166
# print(ext_eculid(a, b))