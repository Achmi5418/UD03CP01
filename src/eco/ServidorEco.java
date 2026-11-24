import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEco {

    public static void main(String[] args) {
        final int PUERTO = 2000;

        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            System.out.println("Servidor eco escuchando en puerto " + PUERTO);

            while (true) {
                try (Socket cliente = servidor.accept();
                     BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                     PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)) {

                    System.out.println("Cliente conectado: " + cliente.getInetAddress());

                    String linea;
                    while ((linea = entrada.readLine()) != null) {
                        if (linea.equals("FIN")) {
                            System.out.println("Cliente solicita cierre.");
                            break;
                        }

                        System.out.println("Recibido: " + linea);
                        salida.println(linea.toUpperCase());
                    }

                } catch (IOException e) {
                    System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
                }

                System.out.println("Esperando nuevo cliente...");
            }

        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}