# echo-client.py
import socket
HOST = "127.0.0.1"  
PORT = 65432  
with socket.socket() as s:
    s.connect((HOST, PORT))
    while True:
        data = input("Client: ")
        s.sendall(bytes(data, 'utf-8'))
        data = s.recv(1024)
        print(f"Server: {data.decode('utf-8')}")
