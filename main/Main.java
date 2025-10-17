package main;

import model.*;
import service.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalService rentalService = new RentalService();

        // Seed data
        rentalService.addCar(new EconomyCar("E001", "Toyota", "Etios", 1500));
        rentalService.addCar(new EconomyCar("E002", "Suzuki", "Swift", 1200));
        rentalService.addCar(new LuxuryCar("L001", "BMW", "X5", 8000));
        rentalService.addCar(new LuxuryCar("L002", "Audi", "A6", 7500));

        while (true) {
            System.out.println("\n===== Car Rental System =====");
            System.out.println("1. Show Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Show All Rentals");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> rentalService.showAvailableCars();
                case 2 -> {
                    System.out.print("Enter Customer ID: ");
                    String cid = sc.next();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Phone: ");
                    String phone = sc.next();

                    Customer customer = new Customer(cid, name, phone);
                    System.out.print("Enter Car ID to Rent: ");
                    String carId = sc.next();
                    System.out.print("Enter Number of Days: ");
                    int days = sc.nextInt();

                    rentalService.rentCar(customer, carId, days);
                }
                case 3 -> {
                    System.out.print("Enter Car ID to Return: ");
                    String carId = sc.next();
                    rentalService.returnCar(carId);
                }
                case 4 -> rentalService.showAllRentals();
                case 5 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
