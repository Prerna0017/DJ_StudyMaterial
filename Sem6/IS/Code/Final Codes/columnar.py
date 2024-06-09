import math

def find_rank(key):
    rank = 0
    for i in sorted(key):
        key = key.replace(i, str(rank), 1)
        rank += 1
    key = [int(i) for i in key]
    return key

def encrypt(pt, key):
    pt = pt.upper().replace(" ","")
    key = key.upper().replace(" ","")

    cols = len(key)
    rows = math.ceil(len(pt)/cols)
    key_rank = find_rank(key)
    print(key_rank)

    pt += ''.join(['X'] * (rows * cols - len(pt)))

    matrix = [list(pt[i: i+cols]) for i in range(0, len(pt), cols)]
    for i in range(rows):
        print(matrix[i])

    ciphertext=''

    for ind in range(len(key_rank)):
        col = key_rank.index(ind)
        for i in range(rows):
            ciphertext+= matrix[i][col]

    return ciphertext
    

def decrypt(cip, key):
    cip = cip.upper().replace(" ","")
    key = key.upper().replace(" ","")

    cols = len(key)
    rows = math.ceil(len(cip)/cols)
    key_rank = find_rank(key)

    cip += ''.join(['X'] * (rows * cols - len(cip)))

    cip_mat = [[0 for col in range(cols)] for row in range(rows)]

    count=0

    for ind in range(len(key_rank)):
        col = key_rank.index(ind)
        for i in range(rows):
            cip_mat[i][col] = cip[count]
            count+=1

    result=''
    for row in cip_mat:
        result+=''.join(row)

    return result.rstrip('X')

# pt, key = 'wearediscoveredfleeatonce', 'zebras'
pt, key = 'were89ik', 'io'
ciphertext = encrypt(pt, key)
decrypted = decrypt(ciphertext, key)
print(f"After encryption, Cipher Text: {ciphertext}\nAfter decryption, Plain Text: {decrypted}")
