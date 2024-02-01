import java.util.*;
import java.io.Console;
//import java.lang.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart");

        List<String> cartItems = new ArrayList<>();

        Console cons = System.console();
        String input = "";

        // establish option to quit programme
        while (!input.equals("quit")) {
            input = cons.readLine("> ").toLowerCase();
            //input = input.toLowerCase();
            // switch (input) {
            //     case list:
                    
            //         break;
            
            //     default:
            //         break;
            if (input.equals("list")) {
                if (cartItems.size() > 0) {
                    for (int i = 0; i < cartItems.size(); i++) {
                        System.out.println((i+1) + ". " + cartItems.get(i));
                        //System.out.printf("%d. %s\n", (i+1), cartItems.get(i));
                    }
                } else {
                    System.out.println("Your cart is empty");
                }
            
            }

            if (input.startsWith("add")) {
                input = input.replace(',', ' ');

                Scanner sc = new Scanner(input.substring(4));   // add 4 <--
                String stringVal = "";
                while (sc.hasNext()) {
                    stringVal = sc.next();
                    if (cartItems.contains(stringVal)) {
                        System.err.printf("You have %s in your cart\n", stringVal);
                    } else {
                        cartItems.add(stringVal);
                        System.out.println(stringVal + " added to cart");
                    }
                }
            }

            if (input.startsWith("delete")) {
                Scanner scanDelete = new Scanner(input.substring(7));   // delete 7
                int intVal;

                while (scanDelete.hasNext()) {
                    intVal = scanDelete.nextInt();
                    intVal = intVal - 1;

                    if (intVal < cartItems.size()) {
                        System.out.println(cartItems.get(intVal) + " removed from cart");
                        cartItems.remove(intVal);
                    } else {
                        System.err.println("Incorrect item index");
                    }

                    //stringVal = scan.next();
                    // Integer cartPosition = Integer.parseInt(stringVal);
                    // cartPosition = cartPosition - 1;

                    // if (cartPosition < cartItems.size()) {
                    //     cartItems.remove(cartPosition);
                    // } else {
                    //     System.err.println("Incorrect item index");
                    //}

                }
            }

        }

        System.out.println("Thank you for shopping. See you again.");
    }
}
