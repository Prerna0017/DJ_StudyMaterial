def encrypt(text,s):
    result = ""
    for char in text:
        if char.isnumeric():
            base = ord('0')
            result += chr((ord(char)-base + s)%10+base)
        else:
            base = ord('A') if char.isupper() else ord('a')
            result += chr((ord(char)-base + s)%26+base)
    return result

def decrypt(text,s):
    result = ""
    for char in text:
        if char.isnumeric():
            base = ord('0')
            result += chr((ord(char)-base - s)%10+base)
        else:
            base = ord('A') if char.isupper() else ord('a')
            result += chr((ord(char)-base - s)%26+base)
    return result

text = "BtechZ9"
s = 4
cipherText=encrypt(text,s)

print (f"Text:{text}\nShift:{s}\nCipher:{cipherText}\nDecrypted:{decrypt(cipherText,s)}")