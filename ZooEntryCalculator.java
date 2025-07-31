import java.util.Scanner;

public class ZooEntryCalculator {

    // Calculates total charge for a single group based on entry rules
    public static int calculateGroupCharge(int numChildren, int numAdults, int numSeniors) {
        int totalCharge = 0;

        // Adults pay $10 each
        totalCharge += numAdults * 10;

        // Seniors pay $8 each
        totalCharge += numSeniors * 8;

        // Adults and seniors can each accompany one child
        int totalAccompanying = numAdults + numSeniors;

        // Children accompanied by an adult/senior pay less
        int accompaniedChildren = Math.min(numChildren, totalAccompanying);

        // Extra children are charged at unaccompanied rate
        int unaccompaniedChildren = numChildren - accompaniedChildren;

        // $2 per accompanied child
        totalCharge += accompaniedChildren * 2;

        // $5 per unaccompanied child
        totalCharge += unaccompaniedChildren * 5;

        return totalCharge;
    }

    public static void main(String[] args) {
        // Scanner auto-closes after this block
        try (Scanner scanner = new Scanner(System.in)) {
            int totalTakings = 0;

            while (true) {
                System.out.print("Enter a group? (Yes=1/No=0): ");
                String response = scanner.nextLine().trim();

                // Exit if user enters 0
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

                    // Calculate and show charge for this group
                    int groupCharge = calculateGroupCharge(numChildren, numAdults, numSeniors);
                    totalTakings += groupCharge;

                    System.out.println("Total entry charge is $" + groupCharge);
                } else {
                    // Any input that's not 1 or 0 is treated as exit
                    break;
                }
            }

            // Show final total after all groups processed
            System.out.println("Total takings: $" + totalTakings);
        }
    }
}
