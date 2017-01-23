/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecalc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author JP
 */
public class ClienteCalc {

    private static int operando1, operando2, operador, resultado;

    public static void main(String[] args) {
        try {
            System.out.println("Creando socket cliente");
            Socket clienteSocket = new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress direc = new InetSocketAddress("localhost", 6000);
            clienteSocket.connect(direc);

            InputStream leer = clienteSocket.getInputStream();
            OutputStream escribir = clienteSocket.getOutputStream();

            operando1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce o primeiro numero"));

            operando2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce o segundo numero"));

            
            operador = Integer.parseInt(JOptionPane.showInputDialog("Introduce o operador \n" + "1-suma,\n" + " 2-resta,\n" + " 3-division,\n" + " 4-multiplicacion  "));

            escribir.write(operando1);
            escribir.write(operando2);
            escribir.write(operador);

            resultado=leer.read();

            clienteSocket.close();

        } catch (IOException ex) {

        }
    }

}
