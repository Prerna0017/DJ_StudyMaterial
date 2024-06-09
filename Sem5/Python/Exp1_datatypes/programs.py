a = "Prerna"
print (type(a) , ": ", a)

a = 'o'
print (type(a) , ": ", a)

a = True
print (type(a) , ": ", a)

a = 123
print (type(a) , ": ", a)

a = 18.90
print (type(a) , ": ", a)

a = 90+90j
print (type(a) , ": ", a)

a = ["Prerna", 90, 98.90, 78+89j, 'a']
print (type(a) , ": ", a)

a = ("Prerna", 90, 98.90, 78+89j, 'a')
print (type(a) , ": ", a)

a = range(2, 10)
print (type(a) , ": ", a , " --> ", list(a))

a = range(10, 2, -2)
print (type(a) , ": ", a , " --> ", list(a))

a = {'sap': 6090, 'name':'prerna', 78: 89+90j}
print (type(a) , ": ", a )
print ("Keys of Dict: ", a.keys())
print ("Values of Dict: ", a.values())

# a = set([78, 'prerna', 'p', 90+0j, 43.3])
# is same as 
a = {78, 'prerna', 'p', 90+0j, 43.3}
print (type(a) , ": ", a )

a = b'hi'
print (type(a) , ": ", a)

a = None
print (type(a) , ": ", a)

a = id(89)
print ("Id of a --> id(a): ", a)

a = 27
print("Square of 27: ",a**2)
print("Square Root of 27: ",a**0.5)
print("Cube Root of 27: " ,a**0.3333333333333333)

k=1190
print(bin(k).replace('0b',''))

print("Left shift 2 bit: ", bin(k<<2).replace('0b',''))
print("Right shift 2 bit: ", bin(k>>2).replace('0b',''))



