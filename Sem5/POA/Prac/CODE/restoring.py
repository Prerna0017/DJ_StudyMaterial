def twosComplement(num):
    onesComp=''
    for i in num:
        if i == '0':
            onesComp += '1'
        else:
            onesComp += '0'
    return bin(int(onesComp,2) + int('1',2)).replace('0b','')

num1 = int(input("Enter Num1: "))
num2 = int(input("Enter Num2: "))

binNum1 = bin(abs(num1)).replace("0b",'')
binNum2 = bin(abs(num2)).replace("0b",'')

if len(binNum1) >= len(binNum2):
    maxlen = len(binNum1)
else:
    maxlen = len(binNum2)

maxlen+=1

binNum1 = binNum1.zfill(maxlen)
binNum2 = binNum2.zfill(maxlen)

binCompNum2 = twosComplement(binNum2)
binCompNum2 = binCompNum2.zfill(maxlen)

print('Number 1 binary:',binNum1)
print('Number 2 binary:',binNum2)
# print('Number 1 complement:',binCompNum1)

count = maxlen
m = binNum2
minusm = binCompNum2
q = binNum1
# q1 = '0'
a = "0"
a = a.zfill(maxlen)
leftshift = ''
print("A\t\tQ\n")

while count>0:
    print("----------------------------------------------------")
    print(a+"\t\t"+q)
    merged = a[1:]+q
    leftshift =""

    for i in range(len(merged)):
        leftshift += merged[i]

    a = leftshift[:maxlen]
    a = bin(int(a,2) + int(minusm,2)).replace("0b",'')
    if(len(a)>maxlen):
        a = a[1:]   #ignore carry
    a = a.zfill(maxlen)

    if a[0] =='1':
        q = leftshift[maxlen:maxlen*2]
        q += '0'
        a = bin(int(a,2) + int(m,2)).replace("0b",'')
        if(len(a)>maxlen):
            a = a[1:]   #ignore carry
        a = a.zfill(maxlen)
    else:
        q = leftshift[maxlen:maxlen*2]
        q += '1'
    print(a+"\t\t"+q)

    count -= 1
    
print("Remainder = ", int(a,2))
print("Quotient = ", int(q,2))