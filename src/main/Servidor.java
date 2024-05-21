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
            ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            // Envia cada caractere da mensagem para o cliente
            saida.writeObject(mensagem);
           
            System.out.println("SERVIDOR: " + entrada.readObject());
        
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
