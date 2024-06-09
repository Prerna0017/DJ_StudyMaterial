plain = input("Enter text: ").upper()
key = input("Enter key: ").upper()
padded_key = key

if len(key)<len(plain):
    for i in range(len(plain)-len(key)):
        padded_key+=key[i%len(key)]

key = padded_key

encrypt, decrypt = "",""

for p,q in zip(plain,key):
    encrypt += chr(ord(p)^ord(q))

for p,q in zip(encrypt,key):
    decrypt += chr(ord(p)^ord(q))

print("Encrypted: ",encrypt)    
print("Decrypted: ",decrypt)    