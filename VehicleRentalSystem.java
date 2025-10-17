import java.util.Scanner;

// Base Class
class Vehicle{
    protected String name;
    protected double rentPerDay;

    public Vehicle(String name, double rentPerDay) {
        this.name = name;
        this.rentPerDay = rentPerDay;
    }

    public double calculateRent(int days) {
        double total = days * rentPerDay;
        // Apply 10% discount if rented for more than 7 days
        if (days > 7) {
            total = total * 0.9; // 10% off
        }
        return total;
    }
}

// Derived Classes
class Car extends Vehicle {
    public Car() {
        super("Car", 1500);
    }
}

class Bike extends Vehicle {
    public Bike() {
        super("Bike", 700);
    }
}

class Truck extends Vehicle {
    public Truck() {
        super("Truck", 2500);
    }
}

// Main System Class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueRental = true;

        System.out.println("===== Welcome to Vehicle Rental System =====");

        while (continueRental) {
            System.out.println("\nChoose a Vehicle Type:");
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.println("3. Truck");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            Vehicle vehicle = null;

            switch (choice) {
                case 1:
                    vehicle = new Car();
                    break;
                case 2:
                    vehicle = new Bike();
                    break;
                case 3:
                    vehicle = new Truck();
                    break;
                case 4:
                    System.out.println("Thank you for visiting! Goodbye 👋");
                    continueRental = false;
                    continue;
                default:
                    System.out.println("Invalid choice! Try again.");
                    continue;
            }

            System.out.print("Enter number of days to rent: ");
            int days = sc.nextInt();

            double totalCost = vehicle.calculateRent(days);

            System.out.println("\n===== Rental Summary =====");
            System.out.println("Vehicle Selected: " + vehicle.name);
            System.out.println("Rent per day: ₹" + vehicle.rentPerDay);
            System.out.println("Number of days: " + days);
            if (days > 7)
                System.out.println("Discount Applied: 10%");
            System.out.println("Total Rent: ₹" + totalCost);
            System.out.println("===========================");

            System.out.print("\nDo you want to rent another vehicle? (yes/no): ");
            String again = sc.next().toLowerCase();
            continueRental = again.equals("yes");
        }

        sc.close();
    }
}
