#RSA encryption/Decryption and Digital Signature
import random, hashlib

def gcd(a, b): 
    while b != 0: 
        a, b = b, a % b
    return a

def generate_keys():
    p = int(input("Enter p (greater than 100): ")) #113
    q = int(input("Enter q (greater than 100): ")) #101
    n = p * q
    phi = (p - 1) * (q - 1)
    e = random.randint(1, phi)
    while gcd(e, phi) != 1:
        e = random.randint(1, phi)
    d = pow(e, -1, phi)
    return (e, n), (d, n)

def encrypt(message, public_key):
    e, n = public_key
    encrypted_message = [pow(ord(char), e, n) for char in message]
    return encrypted_message

def decrypt(encrypted_message, private_key):
    d, n = private_key
    decrypted_message = [chr(pow(char, d, n)) for char in encrypted_message]
    return ''.join(decrypted_message)

message = "Hello, World!"
public_key, private_key = generate_keys()

encrypted_message = encrypt(message, public_key)
decrypted_message = decrypt(encrypted_message, private_key)

print("Public key: ",public_key)
print("Private key: ",private_key)

print(f"Original message:{message}\nEncryptedMeessage:{encrypted_message}\nDecryptedMsg:{decrypted_message}")

#Digital Signature part
hash_value = hashlib.md5(message.encode()).hexdigest()
print("Hash value at sender end: ", hash_value)

signature = encrypt(hash_value, public_key)
print("Digital signature: ", signature) 

# receiver side 
hash_value_check = decrypt(signature, private_key)
print("Hash value checked at receiver end: ", hash_value_check)

if hash_value_check == hash_value:
    print("Verified")
else:
    print("Not verified")