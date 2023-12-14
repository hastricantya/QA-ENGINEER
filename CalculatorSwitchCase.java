import java.util.Scanner;
public class CalculatorSwitchCase {

        public static void main(String[] args) {

            char operator;
            Double number1, number2, result;

            // Membuat object scanner
            Scanner input = new Scanner(System.in);

            // Perintah untuk user memasukkan operator
            System.out.println("Pilih operator: +, -, *, atau /");
            operator = input.next().charAt(0);

            // Perintah untuk user memasukkan angka
            System.out.println("Masukkan angka pertama");
            number1 = input.nextDouble();

            System.out.println("Masukkan angka kedua");
            number2 = input.nextDouble();

            switch (operator) {

                // switch case operator
                case '+':
                    result = number1 + number2;
                    System.out.println(number1 + " + " + number2 + " = " + result);
                    break;

                // performs subtraction between numbers
                case '-':
                    result = number1 - number2;
                    System.out.println(number1 + " - " + number2 + " = " + result);
                    break;

                // performs multiplication between numbers
                case '*':
                    result = number1 * number2;
                    System.out.println(number1 + " * " + number2 + " = " + result);
                    break;

                // performs division between numbers
                case '/':
                    result = number1 / number2;
                    System.out.println(number1 + " / " + number2 + " = " + result);
                    break;

                default:
                    System.out.println("Operator tidak dikenali!");
                    break;
            }

            input.close();
        }
    }

