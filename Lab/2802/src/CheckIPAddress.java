import java.util.Scanner;

public class CheckIPAddress {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String ipAddress = scanner.nextLine();
        
        if (isValidIPv4(ipAddress)) {
            System.out.println(ipAddress + " is a valid IPv4 address.");
        } else if (isValidIPv6(ipAddress)) {
            System.out.println(ipAddress + " is a valid IPv6 address.");
        } else {
            System.out.println(ipAddress + " is not a valid IP address.");
        }
    }

    public static boolean isValidIPv4(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidIPv6(String ipAddress) {
        String[] parts = ipAddress.split(":");
        if (parts.length != 8) {
            return false;
        }
        for (String part : parts) {
            try {
                int num = Integer.parseInt(part, 16);
                if (num < 0 || num > 65535) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
}
