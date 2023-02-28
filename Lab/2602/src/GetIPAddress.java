import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIPAddress {
    public static void main(String[] args) {
        String[] domains = {"javapoint.com", "youtube.com", "google.com", "facebook.com"};
        System.out.println("IP Addresses of the given domains:");
        for (String domain : domains) {
            try {
                InetAddress[] addresses = InetAddress.getAllByName(domain);
                for (InetAddress address : addresses) {
                    System.out.println(domain + ": " + address.getHostAddress());
                }
            } catch (UnknownHostException e) {
                System.out.println("Error occurred while getting the IP address of " + domain + ": " + e.getMessage());
            }
        }
    }
}
