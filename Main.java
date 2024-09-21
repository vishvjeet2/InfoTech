import java.util.Scanner;

public class IntegerToWordConverter {
    private static final String[] units = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static String convertIntegerToWords(int number) {
        if (number == 0) {
            return "zero";
        }

        String words = "";
        if (number >= 1000000000) {
            words += convertIntegerToWords(number / 1000000000) + " billion ";
            number %= 1000000000;
        }

        if (number >= 1000000) {
            words += convertIntegerToWords(number / 1000000) + " million ";
            number %= 1000000;
        }

        if (number >= 1000) {
            words += convertIntegerToWords(number / 1000) + " thousand ";
            number %= 1000;
        }

        if (number >= 100) {
            words += units[number / 100] + " hundred ";
            number %= 100;
        }

        if (number >= 20) {
            words += tens[(number - 20) / 10] + " ";
            number %= 10;
        }

        if (number >= 10) {
            words += teens[number - 10];
        } else if (number > 0) {
            words += units[number];
        }

        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        scanner.close();

        String words = convertIntegerToWords(number);
        System.out.println("Word representation: " + words);
    }
}
