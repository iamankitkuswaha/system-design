package entity;

import java.time.Duration;
import java.time.LocalDate;

public class Reservation {
    private final String id;
    private Customer customer;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalRent;

    public Reservation(String id, Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalRent = Duration.between(startDate,endDate).toHours()*car.getRentalPricePerHour();
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTotalRent() {
        return totalRent;
    }
}
