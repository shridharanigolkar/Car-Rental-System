package model;

public class Rental {
    private Customer customer;
    private Car car;
    private int days;
    private double totalRent;

    public Rental(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.days = days;
        this.totalRent = car.calculateRent(days);
    }

    public Customer getCustomer() { return customer; }
    public Car getCar() { return car; }
    public double getTotalRent() { return totalRent; }

    @Override
    public String toString() {
        return "Customer: " + customer.getName() + " | Car: " + car.getBrand() + " " + car.getModel() +
               " | Days: " + days + " | Total Rent: " + totalRent;
    }
}
