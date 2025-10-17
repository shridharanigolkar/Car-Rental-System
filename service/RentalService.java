package service;

import model.*;
import java.util.*;

public class RentalService {
    private List<Car> cars = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();

    public void addCar(Car car) { cars.add(car); }

    public void showAvailableCars() {
        System.out.println("🚗 Available Cars:");
        cars.stream().filter(Car::isAvailable).forEach(System.out::println);
    }

    public void rentCar(Customer customer, String carId, int days) {
        Optional<Car> optionalCar = cars.stream()
                .filter(c -> c.getCarId().equalsIgnoreCase(carId) && c.isAvailable())
                .findFirst();

        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setAvailable(false);
            Rental rental = new Rental(customer, car, days);
            rentals.add(rental);
            System.out.println("\n✅ Rental Confirmed!");
            System.out.println(rental);
        } else {
            System.out.println("\n❌ Car not available or invalid Car ID!");
        }
    }

    public void returnCar(String carId) {
        cars.stream()
            .filter(c -> c.getCarId().equalsIgnoreCase(carId))
            .findFirst()
            .ifPresentOrElse(car -> {
                car.setAvailable(true);
                System.out.println("\n✅ Car Returned Successfully!");
            }, () -> System.out.println("\n❌ Car ID not found!"));
    }

    public void showAllRentals() {
        System.out.println("\n🧾 Rental Records:");
        rentals.forEach(System.out::println);
    }
}
