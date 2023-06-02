import java.io.IOException;
import java.net.*;

public class MulticastReceiver{

    public static void main(String[] args){
        try{
            // Mulicast group address
            InetAddress group = InetAddress.getByName("224.0.0.1");
            // Multicast group port
            int port = 8888;

            MulticastSocket socket = new MulticastSocket(null);
            SocketAddress socketAddress = new java.net.InetSocketAddress(port);
            NetworkInterface networkInterface = NetworkInterface.getByName("Wireless LAN adapter Wi-Fi");
            socket.bind(socketAddress);
            socket.joinGroup(new java.net.InetSocketAddress(group, port), networkInterface);

            System.out.println("Multicast Receiver Started. Listening for messages...");
            byte[] buffer = new byte[1024];

            while(true){

                // Create a datagram packet for receiving data
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Receiver the data
                socket.receive(packet);

                // Convert the received data to a string
                String messageString = new String(packet.getData(), 0, packet.getLength());

                // Display the received message
                System.out.println("Received message: " + messageString);
            }
        }catch(IOException e){
            e.printStackTrace();
           }
    }
}