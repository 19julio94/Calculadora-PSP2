/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcalc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author JP
 */
public class ServidorCalc {

    private static int operando1, operando2, operador;
    private static int resultado;

    public static void main(String[] args) {

        try {
            System.out.println("Creando socket Servidor");
            ServerSocket serversocket = new ServerSocket();
            System.out.println("Realizando bind");

            InetSocketAddress direc = new InetSocketAddress("localhost", 6000);
            serversocket.bind(direc);

            System.out.println("Aceptando Conexions");

            Socket socket = serversocket.accept();
            System.out.println("Conexion recibida");

            InputStream leer = socket.getInputStream();
            OutputStream escribir = socket.getOutputStream();

            operando1 = leer.read();
            operando2 = leer.read();
            operador = leer.read();

            System.out.println("Mensaxe recibida " + operando1);
            System.out.println("Mensaxe recibida " + operando2);

            switch (operador) {
                case 1:

                    JOptionPane.showMessageDialog(null, resultado = operando1 + operando2);
                    escribir.write(resultado);
                    break;

                case 2:

                    JOptionPane.showMessageDialog(null, resultado = operando1 - operando2);
                    escribir.write(resultado);
                    break;

                case 3:

                    JOptionPane.showMessageDialog(null, resultado = operando1 / operando2);
                    escribir.write(resultado);
                    break;

                case 4:

                    JOptionPane.showMessageDialog(null, resultado = operando1 * operando2);
                    escribir.write(resultado);
            }

            System.out.println("Cerrando socket");

            socket.close();
            System.out.println("Cerrando socket servidor");

            serversocket.close();

            System.out.println("¡¡FIN!!");

        } catch (IOException ex) {

        }
    }
}
