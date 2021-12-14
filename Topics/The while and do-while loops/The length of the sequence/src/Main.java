import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int valueGiven;
        int counter = 0;

        do {
            valueGiven = scanner.nextInt();
            if (valueGiven == 0) {
                break;
            } else {
                counter++;
            }
        } while (valueGiven != 0);

        System.out.println(counter);
    }
}
