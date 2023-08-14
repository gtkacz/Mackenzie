import socket

# Define as cores
RED = "\033[1;31m"  
BLUE = "\033[1;34m"
CYAN = "\033[1;36m"
GREEN = "\033[0;32m"
RESET = "\033[0;0m"
BOLD    = "\033[;1m"

HOST = '192.168.0.15'  # Endereço IP do servidor
PORT = 32218        # Porta do socket

# Cria o socket do cliente
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Conecta ao servidor
s.connect((HOST, PORT))
print(GREEN + 'Conectado ao servidor' + RESET)

while True:
    # Pede ao usuário para digitar uma mensagem
    message = input(BLUE + 'Digite uma mensagem: ' + RESET + BOLD)

    # Envia a mensagem para o servidor
    s.send(message.encode())

    # Verifica se a mensagem é para encerrar a conexão
    if message == 'QUIT':
        print(RED + 'Conexão encerrada pelo cliente' + RESET)
        break

    # Recebe a resposta do servidor
    data = s.recv(1024)

    # Imprime a resposta recebida
    print(CYAN + 'Resposta do servidor: ' + RESET + data.decode())

# Encerra a conexão
s.close()
