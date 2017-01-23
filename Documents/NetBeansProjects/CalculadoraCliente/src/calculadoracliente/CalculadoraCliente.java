package calculadoracliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JP
 */
public class CalculadoraCliente {

    private static int operando1, operando2, operador;

    public static void main(String[] args) {
        try {
            System.out.println("Creando socket cliente");
            Socket clienteSocket = new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress direc = new InetSocketAddress("localhost", 5555);
            clienteSocket.connect(direc);

            OutputStream escribir = clienteSocket.getOutputStream();

            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce o primer operando");

            operando1 = sc.nextInt();
            
            System.out.println("Introduce o segundo operando");

            operando2 = sc.nextInt();
            
            System.out.println("Introduce o operador(1-suma, 2-resta, 3-division, 4-multiplicacion");

            operador = sc.nextInt();
            
            escribir.write(operando1);
            escribir.write(operando2);
            escribir.write(operador);

            clienteSocket.close();

        } catch (IOException ex) {

        }
    }

}
