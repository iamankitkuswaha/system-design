package repository;

import entity.Car;
import entity.Customer;
import entity.Reservation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRepository {
    private InMemoryRepository inMemoryRepository = null;
    private Map<String, Customer>customerMap;
    private Map<String, Car> carMap;
    private Map<String, Reservation>reservationMap;

    private  InMemoryRepository(){
        customerMap = new ConcurrentHashMap<>();
        carMap      = new ConcurrentHashMap<>();
        reservationMap = new ConcurrentHashMap<>();
    }

    public synchronized InMemoryRepository getInstance(){
        if(inMemoryRepository == null)
            inMemoryRepository = new InMemoryRepository();
        return inMemoryRepository;
    }

    public Map<String, Customer> getCustomerMap() {
        return customerMap;
    }

    public Map<String, Car> getCarMap() {
        return carMap;
    }

    public Map<String, Reservation> getReservationMap() {
        return reservationMap;
    }
}
