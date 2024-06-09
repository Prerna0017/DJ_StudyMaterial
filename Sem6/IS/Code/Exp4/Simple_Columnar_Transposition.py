def ColTT_Enc(plain_text, key):
    matrix = []
    for i in range(key):
        matrix.append([])
    for i in range(len(plain_text)):
        matrix[i % key].append(plain_text[i])
    for i in matrix:
        print(i)
    cypher_text = ''
    for i in matrix:
        for char in i:
            cypher_text += char
    print("Cipher text of Columnar Transposition is " + cypher_text)
    return cypher_text


def ColTT_Dec(cypher_text, key):
    matrix = []
    for i in range(key):
        matrix.append([])
    count = int(len(cypher_text)/key)
    length = 0
    extra = int(len(cypher_text) % key)
    for charlist in matrix:
        for j in range(count):
            charlist.append(cypher_text[length])
            length = length+1
        if (extra != 0):
            charlist.append(cypher_text[length])
            length = length+1
            extra = extra-1
    for i in matrix:
        print(i)
    plain_text = ''
    for i in range(key+1):
        for charlist in matrix:
            if i > len(charlist)-1:
                continue
            plain_text = plain_text + charlist[i]
    print("Decrypted text of Columnar Transposition is " + plain_text)

string = input("Enter a string:")
col = int(input("Enter column number:"))
c2 = ColTT_Enc(string, col)
ColTT_Dec(c2, col)