import java.util.Scanner;

public class Modula1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print(""
                + " __________\r\n"
                + "| ________ |\r\n"
                + "||12345678||\r\n"
                + "|\"\"\"\"\"\"\"\"\"\"|\r\n"
                + "|[M|#|C][-]|\r\n"
                + "|[7|8|9][+]|\r\n"
                + "|[4|5|6][x]|\r\n"
                + "|[1|2|3][%]|\r\n"
                + "|[.|O|:][=]|\r\n"
                + "\"==========\"\n");
        System.out.print("Welcome to the simple calculator\n");
        System.out.print("you can enter >Exit< to leave\n");
        while (true) {
            System.out.print("Enter a simple expression using * / + - \n: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.print("Have a nice day and thank you for choosing the simple method");
                scanner.close(); // this is here to prevent data leaks?
                break;
            } else if (countOperators(userInput) > 1 || !userInput.matches("^[0-9]+[-+*/]+[0-9]+$")) {
                System.out.println("Sorry, simple equations only");
            } else if (countOperators(userInput) == 1 && userInput.matches("^[0-9]+[-+*/]+[0-9]+$")) {
                float result = handleInput(userInput);
                System.out.println(result);
            }
        }
    }

    private static int countOperators(String input) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == '*' || c == '-' || c == '+' || c == '/') {
                count += 1;
            }
        }
        return count;
    }

    private static float handleInput(String input) {
        float result = 0.0f;
        // split the input string based on operator
        String[] equationParts = input.split("\\s*[-+*/]\\s*");
        if (equationParts.length != 2) {
            System.out.println("Invalid equation format.");
            return result;
        }
        float num1 = Float.parseFloat(equationParts[0]);
        float num2 = Float.parseFloat(equationParts[1]);
        // determine the operator by turning everything thats not a op into white space
        char operator = input.replaceAll("[^-+*/]", "").charAt(0);
        // the simple operation
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // check for division by zero
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Cannot divide by zero.");
                    return result;
                }
                break;
            default:
                System.out.println("Invalid operator.");
                return result;
        }
        return result;
    }
}
