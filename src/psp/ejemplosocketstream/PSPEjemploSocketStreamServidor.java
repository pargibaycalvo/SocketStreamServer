/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp.ejemplosocketstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ped90
 */
public class PSPEjemploSocketStreamServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Creando ServidorSocket");

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");

            //añadir ip de tu equipo o localhost para el mismo equipo
            InetSocketAddress addr = new InetSocketAddress("10.0.160.110", 27017);
            serverSocket.bind(addr);

            System.out.println("Aceptando Conexiones Externas");

            Socket newSocket = serverSocket.accept();

            System.out.println("Conexión Externa Recibida");

            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();

            byte[] mensaje = new byte[25];
            long i = 0;

            is.read(mensaje);

            System.out.println("Mensaje: " + new String(mensaje).trim());

            System.out.println("Cerrando Socket Nuevo");

            newSocket.close();

            System.out.println("Cerrando ServidorSocket");

            serverSocket.close();

            System.out.println("Finalizado Con Éxito");

        } catch (IOException e) {
        }
    }

}
