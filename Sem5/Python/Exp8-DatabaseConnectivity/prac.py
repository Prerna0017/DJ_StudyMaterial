import mysql.connector
mydb = mysql.connector.connect(
    host="localhost",
    user = "root",
    password = "Prerna@3803",
    database = "pythonexam"
)
mycursor = mydb.cursor()

# mycursor.execute("Create Database pythonExam")

# mycursor.execute("Show Databases")

# for i in mycursor:
#     print(i)

# mycursor.execute("use pythonexam")

# mycursor.execute("Create table menu(name varchar(30), calories int, price int);")

# mycursor.execute("Show tables;")
# for i in mycursor:
#     print(i)

# mycursor.execute("Desc menu;")
# for i in mycursor:
#     print(i)

# mycursor.execute("Alter table menu add calories int after name")
mycursor.execute("Desc menu;")
for i in mycursor:
    print(i)

# Insert data into the table
# sql = "INSERT INTO menu (name, calories, price) VALUES (%s, %s, %s)"
# value = ("idli", 100, 45)
# mycursor.execute(sql, value)

# mydb.commit()

# mycursor.execute("SELECT * FROM menu;")
# result = mycursor.fetchall()
# print(result)
    
# sql = "INSERT INTO menu (name, calories, price) VALUES (%s, %s, %s)"
# values = [
#     ("dosa", 100, 45),
#     ("rava", 1070, 415),
#     ("poha", 1040, 453),
#     ("sandwich", 10320, 454),
#     ("juice", 10021, 453),
#     ("uttapa", 1002, 455),
#     ("meduwada", 1003, 458),
#     ("samosa", 1006, 459),
#     ("vadapav", 1009, 450),
#     ("paneer", 1008, 945),
#     ("soup", 10077, 405)
# ]
# mycursor.executemany(sql, values)
# mydb.commit()

# mycursor.execute("SELECT * FROM menu;")
# result = mycursor.fetchall()
# print(result)
    
# mycursor.execute("update menu set name = 'paneer kathi roll' where name='paneer'")
# mydb.commit
# mycursor.execute("SELECT * FROM menu;")
# result = mycursor.fetchall()
# print(result)

# mycursor.execute("SELECT * FROM menu;")
# row = mycursor.fetchone()
# print(row)

mycursor.execute("Delete FROM menu where name='idli';")
mycursor.execute("SELECT * FROM menu;")
result = mycursor.fetchall()
for i in result:
    print(i,"\n")

print(mycursor.rowcount, "record inserted.")

