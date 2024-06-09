# Import module
from tkinter import *

# Create object
root = Tk()

# Adjust size
root.geometry("200x200")

# Change the label text


def show():
    text = clicked.get()
    if text == "3D Object":
        label.config(text="List 3D Objects: \n1.Cuboid\n2.Cube")
    else:
        label.config(text="List 2D Objects: \n1.Square\n2.Circle\n3.Rectangle")


# Dropdown menu options
options = [
    "2D Object",
    "3D Object"
]

# datatype of menu text
clicked = StringVar()

# initial menu text
clicked.set("2D Object")

# Create Dropdown menu
drop = OptionMenu(root, clicked, *options)
drop.pack()

# Create button, it will change label text
button = Button(root, text="Submit", command=show).pack()

# Create Label
label = Label(root, text="List 2D Objects: \n1.Square\n2.Circle\n3.Rectangle")
label.pack()

label = Label(root, text="")
label.pack()

label = Label(root, text="Enter your choice")
label.pack()

inputtxt = Text(root, height = 1,
                width = 25,
                bg = "light yellow")

inputtxt.pack()

label = Label(root, text="Enter dimension1")
label.pack()

para1 = Text(root, height = 1,
                width = 25,
                bg = "light yellow")

para1.pack()

label = Label(root, text="Enter dimension2")
label.pack()

para2 = Text(root, height = 1,
                width = 25,
                bg = "light yellow")

para2.pack()

label = Label(root, text="Enter dimension3")
label.pack()

para3 = Text(root, height = 1,
                width = 25,
                bg = "light yellow")

para3.pack()

Display = Button(root, height = 2,
                 width = 20, 
                 text ="Submit Shape",
                 command = lambda:Take_input())


Display.pack()

def Take_input():
    shape = inputtxt.get("1.0", "end-1c")
    p1 = para1.get("1.0", "end-1c")
    p2 = para2.get("1.0", "end-1c")
    p3 = para3.get("1.0", "end-1c")
    print(shape)
    if(shape == "Square"):
        area = int(p1)*int(p1)
        perimeter = 4*int(p1)
        cal = "Area: "+str(area)+" Perimeter: "+str(perimeter)
        label = Label(root, text=cal)
        label.pack()
    if(shape == "Circle"):
        area = 3.14*int(p1)*int(p1)
        perimeter = 2*3.14*int(p1)
        cal = "Area: "+str(area)+" Circumference: "+str(perimeter)
        label = Label(root, text=cal)
        label.pack()
    if(shape == "Rectangle"):
        area = int(p1)*int(p2)
        perimeter = 2*int(p1)+2*int(p2)
        cal = "Area: "+str(area)+" Perimeter: "+str(perimeter)
        label = Label(root, text=cal)
        label.pack()
    if(shape == "Cuboid"):
        area = int(p1)*int(p2)*int(p3)
        cal = "Volume: "+str(area)
        label = Label(root, text=cal)
        label.pack()
    if(shape == "Cuboid"):
        area = int(p1)*int(p2)*int(p3)
        cal = "Volume: "+str(area)
        label = Label(root, text=cal)
        label.pack()
    if(shape == "Cube"):
        area = int(p1)*int(p1)*int(p1)
        cal = "Volume: "+str(area)
        label = Label(root, text=cal)
        label.pack()
    
# Execute tkinter
root.mainloop()
