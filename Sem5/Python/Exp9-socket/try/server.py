# echo-server.py
import socket
HOST = "127.0.0.1"  
PORT = 65432  
with socket.socket() as s:
    s.bind((HOST, PORT))
    s.listen()
    conn, addr = s.accept()
    print(f"Connected by {addr}")
    while True:
        data = conn.recv(1024)
        print(f"Client: {data.decode('utf-8')}")
        data = input("Server: ")
        conn.sendall(bytes(data, 'utf-8'))