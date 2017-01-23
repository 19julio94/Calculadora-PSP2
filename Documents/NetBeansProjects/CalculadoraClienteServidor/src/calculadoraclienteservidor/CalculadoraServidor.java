package calculadoraclienteservidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JP
 */
public class CalculadoraServidor {

    private static int operando1, operando2, operador;
    private static int resultado;

    public static void main(String[] args) {

        try {
            System.out.println("Creando socket Servidor");
            ServerSocket serversocket = new ServerSocket();
            System.out.println("Realizando bind");

            InetSocketAddress direc = new InetSocketAddress("localhost", 5555);
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

                    System.out.println(resultado = operando1 + operando2);

                    break;
                    
                case 2:

                     System.out.println(resultado=operando1-operando2);
                     
                     

                    break;
                    
                case 3:

                     System.out.println(resultado=operando1/operando2);

                    break;
                    
                case 4:

                     System.out.println(resultado=operando1*operando2);

                    break;    
                    
                    

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
