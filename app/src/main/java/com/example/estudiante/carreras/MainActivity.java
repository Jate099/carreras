package com.example.estudiante.carreras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.butto2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"comenzar", Toast.LENGTH_SHORT).show();
 new Thread(new Runnable() {
     @Override
     public void run() {
         try {
             //
             DatagramSocket socket = new DatagramSocket();

             //IP DEL SERVIDOR
             InetAddress address = InetAddress.getByName("10.0.2.2");

             String mensaje = "comenzar";
             DatagramPacket datagrama = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, address, 5000);

             socket.send(datagrama);


             byte[] buffer = new byte[1000];
             DatagramPacket datagrama_respuesta = new DatagramPacket(buffer, buffer.length);
             socket.receive(datagrama_respuesta);

             System.out.println("MENSAJE: "+ new String(datagrama_respuesta.getData()));


             socket.close();



         } catch (SocketException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (UnknownHostException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
     }
 }).start();


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"pausa", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //
                            DatagramSocket socket = new DatagramSocket();

                            //IP DEL SERVIDOR
                            InetAddress address = InetAddress.getByName("10.0.2.2");

                            String mensaje = "pausa";
                            DatagramPacket datagrama = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, address, 5000);

                            socket.send(datagrama);


                            byte[] buffer = new byte[1000];
                            DatagramPacket datagrama_respuesta = new DatagramPacket(buffer, buffer.length);
                            socket.receive(datagrama_respuesta);

                            System.out.println("MENSAJE: "+ new String(datagrama_respuesta.getData()));


                            socket.close();



                        } catch (SocketException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (UnknownHostException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }).start();


            }
        });


    }

}

