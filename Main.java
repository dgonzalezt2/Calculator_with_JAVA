import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        /**
         * ejemplo
         * 
         * '2 + 1 / 3'
         * '5 + 4'
         * '9 * 6 + 2'
         */
        System.out.println("Digite la expresion \n");
        System.out.print("-> ");
        Scanner reader = new Scanner(System.in);
        String expression = reader.nextLine();
        Calculadora calc = new Calculadora();
        calc.scanner(expression);
    }
}
