import java.io.*;

public class JacobiSymbol {

    Console console = System.console(); 

    public JacobiSymbol(int a, int n) {
        if (console == null) {
            System.err.println("Consola nu este disponibilă. Rulați programul dintr-un terminal.");
            System.exit(1);
        }

        int originalA = a; 
        int originalN = n;

        a = a % n; 
        int result = 1;

        while (a != 0) {
            while (a % 2 == 0) {
                a /= 2;
                if (n % 8 == 3 || n % 8 == 5) {
                    result = -result;
                }
            }

            int temp = a;
            a = n;
            n = temp;

            if (a % 4 == 3 && n % 4 == 3) {
                result = -result;
            }

            a = a % n; 
        }

        if (n != 1) {
            result = 0; 
        }

        console.printf("Simbolul lui Jacobi (%d/%d) = %d%n", originalA, originalN, result);
        console.readLine("Apăsați Enter pentru a închide...");
    }

    public static void main(String[] args) {
        new JacobiSymbol(199, 23);
    }
}
