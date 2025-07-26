import java.util.Scanner;

public class ZooEntryCalculator {

    // Method to calculate the total charge for a group
    public static int calculateGroupCharge(int numChildren, int numAdults, int numSeniors) {
        int totalCharge = 0;

        // Adults: $10 each
        totalCharge += numAdults * 10;

        // Seniors: $8 each
        totalCharge += numSeniors * 8;

        // Determine how many children are accompanied
        int totalAccompanying = numAdults + numSeniors;
        int accompaniedChildren = Math.min(numChildren, totalAccompanying);
        int unaccompaniedChildren = numChildren - accompaniedChildren;

        // Accompanied children: $2 each
        totalCharge += accompaniedChildren * 2;

        // Unaccompanied children: $5 each
        totalCharge += unaccompaniedChildren * 5;

        return totalCharge;
    }

    public static void main(String[] args) {
        // Try-with-resources to ensure Scanner is closed properly
        try (Scanner scanner = new Scanner(System.in)) {
            int totalTakings = 0;

            while (true) {
                System.out.print("Enter a group? (Yes=1/No=0): ");
                String response = scanner.nextLine().trim().toUpperCase();

                if (response.equals("0")) {
                    break;
                }

                if (response.equals("1")) {
                    System.out.print("Enter the number of children (age 6-15): ");
                    int numChildren = Integer.parseInt(scanner.nextLine().trim());

                    System.out.print("Enter the number of adults (age 16-59): ");
                    int numAdults = Integer.parseInt(scanner.nextLine().trim());

                    System.out.print("Enter the number of seniors (age 60+): ");
                    int numSeniors = Integer.parseInt(scanner.nextLine().trim());

                    int groupCharge = calculateGroupCharge(numChildren, numAdults, numSeniors);
                    totalTakings += groupCharge;

                    System.out.println("Total entry charge is $" + groupCharge);
                } else {
                    // Any non-Y input (except Q, already handled) is treated as a quit command
                    break;
                }
            }

            System.out.println("Total takings: $" + totalTakings);
        }
    }
}
