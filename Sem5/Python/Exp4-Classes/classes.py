class Student:
    def __init__(self, sap, name, cgpa, city):
        self.sap = sap
        self.name = name
        self.cgpa = cgpa
        self.city = city
    
    def print_details(self):
        print("SAP Id: ",self.sap)
        print("Name: ",self.name)
        print("CGPA: ",self.cgpa)
        print("City: ",self.city)

class Student_clg(Student):
    def __init__(self, sap, name, cgpa, city, clg, course):
        super().__init__(sap, name, cgpa, city)
        self.clg = clg
        self.course = course

    def print(self):
        print("College: ",self.clg)
        print("Branch: ",self.course)

student1 = Student(60004220127, "Prerna", 8.7, "Mumbai")
student1.print_details()

student1.cgpa = 9.9
student1.print_details()

del(student1)
try:
    print(student1)
except Exception as e:
    print(f"Exception Occured: {str(e)}")


student2 = Student_clg(60004220125, "Akshata", 10, "Mumbai", "D. J. Sanghvi", "Computer Engineering")
print("Details of Student 2:\n")
student2.print_details()
student2.print()

