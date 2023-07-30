import socket

socket_object = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# AF_INET -> Address Family (IPv4 in this case)
# SOCK_STREAM -> TCP
# SOCK_DGRAM -> UDP	

# Server's host & port to connect to
host = "127.0.0.1"
port = 4446

# When a Client makes a request, the OS assigns a random port
# to this request, which is also call "Ephemeral Port"

# Whereas a Server has to have a constant port that never changes.

# Establish a connection
socket_object.connect((host, port))

# Send some data
socket_object.sendall(bytes("Hello Server!".encode("UTF-8")))

socket_object.close()