list1 = [9,6,7,8,4,6,6,78,9]
fileWrite = open("Exp6/sortNumInFile/file1.txt",'w')
for i in list1:
    fileWrite.write(str(i))
    fileWrite.write("\n")
fileWrite.close()

fileRead = open("Exp6/sortNumInFile/file1.txt", 'r')
list2=[]
for i in fileRead:
    list2.append(int(i))
fileRead.close()

print(list2)
list2.sort(reverse=True)
print(list2)
fileWrite = open("Exp6/sortNumInFile/file2.txt",'w')
for i in list2:
    fileWrite.write(str(i))
    fileWrite.write("\n")
fileWrite.close()

