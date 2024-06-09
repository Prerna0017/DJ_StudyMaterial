import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="", 
  database="mydatabase"
)

mycursor = mydb.cursor()

# 1. Create Database
# mycursor.execute("CREATE DATABASE mydatabase")

# mycursor.execute("SHOW DATABASES")

# for x in mycursor:
#   print(x)

# 2. Create Table
# mycursor.execute("CREATE TABLE customers (name VARCHAR(255), address VARCHAR(255))")

# mycursor.execute("SHOW TABLES")

# for x in mycursor:
#   print(x)

# 3. Insert Values
# sql = "INSERT INTO customers (name, address) VALUES (%s, %s)"
# val = ("John", "Highway 21")
# mycursor.execute(sql, val)

# mydb.commit()

# print(mycursor.rowcount, "record inserted.")

# sql = "INSERT INTO customers (name, address) VALUES (%s, %s)"
# val = [
#   ('Peter', 'Lowstreet 4'),
#   ('Amy', 'Apple st 652'),
#   ('Hannah', 'Mountain 21'),
#   ('Michael', 'Valley 345'),
#   ('Sandy', 'Ocean blvd 2'),
#   ('Betty', 'Green Grass 1'),
#   ('Richard', 'Sky st 331'),
#   ('Susan', 'One way 98'),
#   ('Vicky', 'Yellow Garden 2'),
#   ('Ben', 'Park Lane 38'),
#   ('William', 'Central st 954'),
#   ('Chuck', 'Main Road 989'),
#   ('Viola', 'Sideway 1633')
# ]

# mycursor.executemany(sql, val)

# mydb.commit()

# print(mycursor.rowcount, "was inserted.")

# 4. Update
# sql = "UPDATE customers SET address = 'Canyon 123' WHERE address = 'Valley 345'"

# mycursor.execute(sql)

# mydb.commit()

# print(mycursor.rowcount, "record(s) affected")

# 5. fetchone()
# query="SELECT * FROM customers"
# mycursor.execute(query)

# first_row=mycursor.fetchone()
# print(first_row)

# 6. delete a row
# sql = "DELETE FROM customers WHERE address = 'Mountain 21'"

# mycursor.execute(sql)

# mydb.commit()

# print(mycursor.rowcount, "record(s) deleted")

# 7. Alter table
# query = "ALTER TABLE customers ADD email VARCHAR(100) AFTER name" 
# # Execute the query  
# mycursor.execute(query) 
  
# # Print description of students table 
# mycursor.execute("desc customers") 
# myresult = mycursor.fetchall() 
# for row in myresult: 
#     print(row) 

# 8.Display Exisiting table

# mycursor.execute("SHOW TABLES")

# print("Table in database: \n")
# for x in mycursor:
#   print(x)
  