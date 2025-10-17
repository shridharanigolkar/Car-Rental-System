package model;

public abstract class Car {
    private String carId;
    private String brand;
    private String model;
    private double baseRatePerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, String model, double baseRatePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.baseRatePerDay = baseRatePerDay;
        this.isAvailable = true;
    }

    public abstract double calculateRent(int days);

    public String getCarId() { return carId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public double getBaseRatePerDay() { return baseRatePerDay; }

    @Override
    public String toString() {
        return carId + " | " + brand + " " + model + " | " + baseRatePerDay + "/day | Available: " + isAvailable;
    }
}
