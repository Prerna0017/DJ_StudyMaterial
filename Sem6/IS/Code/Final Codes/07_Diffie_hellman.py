p = 23
g = 7
a = 4
b = 3

if a>=p or b>=p:
    print("a or b is less than p")
else:
    XA = (g**a) % p
    XB = (g**b) % p
    AK = (XB**a) % p
    BK = (XA**b) % p

    if AK==BK:
        print(AK,BK,"User verified")
    else:
        print("nahhh")