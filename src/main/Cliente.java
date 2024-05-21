package main;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String mensagem;
        try {
            // Conecta ao servidor na porta 12345
            Socket conexao = new Socket("localhost", 12345);
            // Cria streams para enviar e receber objetos
            ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

            // Lê objetos do servidor até receber null
            mensagem = (String) entrada.readObject();
       
            System.out.println("CLIENTE: " + mensagem);
            
            saida.writeObject("OK");
           
            
            
            // Fecha as streams e o socket
            entrada.close();
            saida.close();
            conexao.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
