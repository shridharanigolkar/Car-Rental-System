package model;

public class EconomyCar extends Car {

    public EconomyCar(String carId, String brand, String model, double baseRatePerDay) {
        super(carId, brand, model, baseRatePerDay);
    }

    @Override
    public double calculateRent(int days) {
        double discount = (days > 5) ? 0.10 * getBaseRatePerDay() : 0; // 10% discount for rentals > 5 days
        return days * (getBaseRatePerDay() - discount);
    }
}
