import java.util.Scanner;  // Import Scanner class to allow user input

public class CinemaTicketingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create Scanner object for input

        // Constant for base ticket price
        final double BASE_PRICE = 200.0;
        String day;            // To store the day of the week
        int age, numTickets;   // To store age and number of tickets
        double ticketPrice, totalPrice, finalPrice;  // For price calculations
        String discountType;   // To describe the discount applied
        String ageInput;       // For user input when entering age or "done"

        // Use loop to keep processing customers until user types "done"
        while (true) {
            System.out.print("\nEnter age of the customer (or type 'done' to exit): ");
            ageInput = input.next().trim();  // Read user input as string

            // If the user types "done", exit the program
            if (ageInput.equalsIgnoreCase("done")) {
                System.out.println("Thank you for using the Cinema Ticketing System!");
                break;
            }

            // Convert input to integer age
            age = Integer.parseInt(ageInput);

            // Ask for the day of the week
            System.out.print("Enter day of the week: ");
            day = input.next().trim();  // Read and trim spaces

            // Ask for the number of tickets
            System.out.print("Enter number of tickets: ");
            numTickets = input.nextInt();

            // --- Determine the ticket price based on rules ---

            // Case 1: Children below 7 years old get free tickets
            if (age < 7) {
                ticketPrice = 0;
                discountType = "Free ticket for children below 7";
            }
            // Case 2: Seniors 60+ get 20% discount (compare with Wednesday)
            else if (age >= 60) {
                double seniorPrice = BASE_PRICE * 0.8;  // 20% off
                double wednesdayPrice = (day.equalsIgnoreCase("Wednesday")) ? BASE_PRICE * 0.5 : BASE_PRICE;

                // Apply whichever gives the better discount
                if (seniorPrice < wednesdayPrice) {
                    ticketPrice = seniorPrice;
                    discountType = "20% Senior Citizen Discount";
                } else if (day.equalsIgnoreCase("Wednesday")) {
                    ticketPrice = wednesdayPrice;
                    discountType = "50% Wednesday Discount";
                } else {
                    ticketPrice = seniorPrice;
                    discountType = "20% Senior Citizen Discount";
                }
            }
            // Case 3: Everyone gets 50% off on Wednesday
            else if (day.equalsIgnoreCase("Wednesday")) {
                ticketPrice = BASE_PRICE * 0.5;
                discountType = "50% Wednesday Discount";
            }
            // Case 4: Regular customers
            else {
                ticketPrice = BASE_PRICE;
                discountType = "No discount";
            }

            // --- Calculate total price ---
            totalPrice = ticketPrice * numTickets;  // Base total
            finalPrice = totalPrice;                // Prepare final total

            // Extra 10% discount if total exceeds ₱1000
            if (finalPrice > 1000) {
                finalPrice *= 0.9;  // Apply 10% off
                discountType += " + Extra 10% discount for purchases over ₱1000";
            }

            // --- Display results ---
            System.out.println("\n=== Ticket Summary ===");
            System.out.println("Tickets: " + numTickets + " × ₱" + String.format("%.2f", ticketPrice));
            System.out.println("Discount applied: " + discountType);
            System.out.println("Total before discounts: ₱" + String.format("%.2f", BASE_PRICE * numTickets));
            System.out.println("Final amount to pay: ₱" + String.format("%.2f", finalPrice));

            // Check if minimum purchase requirement is met
            if (finalPrice < 200 && ticketPrice != 0) {
                System.out.println("Note: Minimum purchase not reached.");
            }

            System.out.println("=========================");
        }

        // Close Scanner to release system resources
        input.close();
    }
}
