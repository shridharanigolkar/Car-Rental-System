
package model;

public class LuxuryCar extends Car {

    public LuxuryCar(String carId, String brand, String model, double baseRatePerDay) {
        super(carId, brand, model, baseRatePerDay);
    }

    @Override
    public double calculateRent(int days) {
        double luxuryTax = 0.20 * getBaseRatePerDay(); // 20% luxury tax
        return days * (getBaseRatePerDay() + luxuryTax);
    }
}
