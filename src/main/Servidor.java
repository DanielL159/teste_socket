package main;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        String mensagem = "Hello world!";
        try {
            // Cria um servidor que escuta na porta 12345
            ServerSocket servidor = new ServerSocket(12345);
            // Aceita uma conexão do cliente
            Socket socket = servidor.accept();
            // Cria streams para enviar e receber objetos
            ObjectOutputStream saida = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            ObjectInputStream entrada = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

            // Envia cada caractere da mensagem para o cliente
       
         // Envia a mensagem para o cliente
            saida.writeObject(mensagem);
            saida.flush(); // Certifica-se de que os dados são enviados imediatamente
            System.out.println("SERVIDOR: Mensagem enviada");

            // Espera a confirmação do cliente
            String confirmacao = (String) entrada.readObject();
            System.out.println("SERVIDOR: Confirmação recebida do cliente: " + confirmacao);

            // Fecha as streams e o socket
            entrada.close();
            saida.close();
            socket.close();
            servidor.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
