import socket

socket_object = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

host = "127.0.0.1"
port = 4446

socket_object.bind((host, port))

# this is kinda like an async request, the further execution of the 
# file waits for a response of this listen()
socket_object.listen()

connection_obj, address = socket_object.accept()

data = connection_obj.recv(1024)

print(str(data))

socket_object.close()