package client;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Setup {
    
    public static int port;
    public static String host;
    public static String name;

    private static final String setupNameMsg = "Enter your name:";
    private static final String setupNameError = "The name should be a String";
    
    private static final String setupHostMsg = "Enter host:";
    private static final String setupHostError = "The host name should either be 'localhost' or a IP address (fx 192.168.1.2)";
    
    private static final String setupPortMsg = "Enter port:";
    private static final String setupPortError = "Please enter a number";

    public static void setupName() {
        System.out.println(setupNameMsg);
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.nextLine();
        } catch(InputMismatchException e) {
            System.out.println(setupNameError);
            setupName();
        }        
    }
    
    public static void setupHost() {
        System.out.println(setupHostMsg);
        Scanner scanner = new Scanner(System.in);
        try {
            host = scanner.nextLine();
        } catch(InputMismatchException e) {
            System.out.println(setupHostError);
            setupHost();
        }        
    }
    
    public static void setupPort() {
        System.out.println(setupPortMsg);
        Scanner scanner = new Scanner(System.in);
        try {
            port = scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println(setupPortError);
            setupPort();
        }
    }
}
