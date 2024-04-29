import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            String[] inputs = input.split("[+-]");
            int num1 = Integer.parseInt(inputs[0]);
            int num2 = Integer.parseInt(inputs[1]);
            char operator = input.charAt(inputs[0].length()); // input 0 다음

            if (num1 == 0 || num2 == 0) {
                if (operator == '-') {
                    throw new SubtractZeroException(); // 내가 예외를 만들 때 throw
                } else {
                    throw new AddZeroException();
                }
            }
            if (num1 < 0 || num1 > 1000 || num2 < 0 || num2 > 1000) {
            	throw new OutOfRangeException();
            }

            int result = 0;
            if (operator == '+')
            	result = num1 + num2;
            if (operator == '-')
                result = num1 - num2;
            if (result < 0 || result > 1000) {
            	throw new OutOfRangeException();
            }
            
            System.out.println(result);
        } catch (OutOfRangeException e) {
            System.out.println("OutOfRangeException");
        } catch (SubtractZeroException e) {
            System.out.println("SubtractZeroException");
        } catch (AddZeroException e) {
            System.out.println("AddZeroException");
        }
    }
}

class OutOfRangeException extends Exception{}
class SubtractZeroException extends Exception{}
class AddZeroException extends Exception{}