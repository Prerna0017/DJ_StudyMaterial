class Employee:
    def __init__(self, empid, name, designation):
        self.empid = empid
        self.name = name
        self.designation = designation

class Developer(Employee):
    def __init__(self, empid, name, designation):
        super().__init__(empid, name, designation)

class Tester(Employee):
    def __init__(self, empid, name, designation):
        super().__init__(empid, name, designation)

class Manager(Employee):
    # workers : list = []
    
    def __init__(self, empid, name, designation):
        super().__init__(empid, name, designation)
        self.workers = []

    def add_worker(self, worker):
        self.workers.append(worker)

    def remove_worker(self, worker):
        self.workers.remove(worker)

    def list_worker(self):
        print(f"All Employee for {self.name}:")
        for i in self.workers:
            print(f"{i.name}")

d1 = Developer(12, "Developer1", "Junior Dev")
d2 = Developer(13, "Developer2", "Sunior Dev")
d3 = Developer(14, "Developer3", "Junior Dev")
d4 = Developer(15, "Developer4", "Sunior Dev")

t1 = Tester(22, "Tester1", "Junior Tester")
t2 = Tester(23, "Tester2", "Senior Tester")
t3 = Tester(24, "Tester3", "Junior Tester")
t4 = Tester(25, "Tester4", "Senior Tester")

m1 = Manager(35, "Manager1", "Team Lead")
m2 = Manager(55, "Manager2", "Project Lead")

m1.add_worker(d1)
m1.add_worker(d2)
m1.add_worker(t1)
m1.add_worker(t2)

m1.list_worker()

m2.add_worker(d3)
m2.add_worker(d4)
m2.add_worker(t3)
m2.add_worker(t4)

m2.list_worker()

m1.remove_worker(t2)
m1.list_worker()






