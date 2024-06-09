import re
file = open("Exp7/sample.txt",'r')
text = file.read()
pattern_names = r'M(?:r\.|rs\.|s\.)[a-zA-z]+'
pattern_email = r'[a-zA-z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z]+'
pattern_mobile = r'\+[0-9]+\s\d{10}'

names = re.findall(pattern_names,text)
print(names)

emails = re.findall(pattern_email,text)
print(emails)

phones = re.findall(pattern_mobile,text)
print(phones)
