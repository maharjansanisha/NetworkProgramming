import java.io.IOException;
import java.net.*;

public class MulticastSender{
    public static void main(String[] args){
        try{
            // Mulicast group address
            InetAddress group = InetAddress.getByName("224.0.0.1");
            // Multicast group port
            int port = 8888;

            // Create a datagram socket
            DatagramSocket socket = new DatagramSocket();

            System.out.println("Multicast Sender Started.\nEnter messages to send.\nEnter 'exit' to quit");

            while(true){

                // Read input from the user
                System.out.println("Message sent: ");
                String message = getUserInput();

                // Check if user wants to exit
                if(message.equalsIgnoreCase("exit")){
                    break;
                }

                // Convert the message to bytes
                byte[] buffer = message.getBytes();

                // Create a datagram for reading data
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length,group, port);

                // Send the packet
                socket.send(packet);

            }

            // Close the socket
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static String getUserInput() throws IOException{
        byte[] buffer = new byte[1024];
        System.in.read(buffer);

        return new String(buffer).trim();
    }
}