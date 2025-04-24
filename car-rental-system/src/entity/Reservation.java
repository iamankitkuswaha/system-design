package entity;

import java.time.Duration;
import java.time.LocalDateTime;

public class Reservation {
    private final String id;
    private Customer customer;
    private Car car;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double totalRent;

    public Reservation(String id, Customer customer, Car car, LocalDateTime startDate, LocalDateTime endDate) {
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public double getTotalRent() {
        return totalRent;
    }
}
