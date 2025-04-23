package service;

import entity.Car;
import entity.CarStatus;
import entity.Customer;
import entity.Reservation;
import payment.PaymentStrategy;
import payment.UPIPayment;
import repository.InMemoryRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ReservationService {
    private static ReservationService reservationService = null;
    private InMemoryRepository inMemoryRepository;
    private CarService carService;
    private Map<String, Reservation> reservationMap;
    private PaymentStrategy paymentStrategy;

    private ReservationService(InMemoryRepository inMemoryRepository){
        this.inMemoryRepository = inMemoryRepository;
        reservationMap = inMemoryRepository.getReservationMap();
        carService =  new CarService();
        paymentStrategy =  new UPIPayment();
    }
    private String generateId(){
        return "RES"+ UUID.randomUUID().toString();
    }
    public static ReservationService getInstance(InMemoryRepository inMemoryRepository){
        if(reservationService == null)
            reservationService = new ReservationService(inMemoryRepository);
        return reservationService;
    }

    public List<Car> searchCars(String companyName, String model, LocalDate startDate, LocalDate endDate){
        List<Car>availableCars = new ArrayList<>();
        for(Car car : inMemoryRepository.getCarMap().values()){
            if(car.getCompanyName().equalsIgnoreCase(companyName) && car.getModel().equalsIgnoreCase(model) && car.getCarStatus().equals(CarStatus.AVAILABLE)){
                if(isCarAvailable(car.getPlateNumber(), startDate, endDate)){
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }
    public synchronized Reservation makeReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate){
        if(isCarAvailable(car.getPlateNumber(), startDate, endDate)){
            String id = generateId();
            Reservation reservation = new Reservation(id, customer, car, startDate, endDate);
            reservationMap.put(id, reservation);
            car.setCarStatus(CarStatus.BOOKED);
            return reservation;
        }
        return null;
    }

    public synchronized boolean cancelReservation(String reservationId){
        if(reservationMap.containsKey(reservationId)){
            Car car = reservationMap.get(reservationId).getCar();
            reservationMap.remove(reservationId);
            car.setCarStatus(CarStatus.AVAILABLE);
            System.out.println(reservationId+" canceled!!");
            return true;
        }else{
            System.out.println(reservationId+" is not present!!");
            return false;
        }
    }

    public boolean processPayment(Reservation reservation){
        return paymentStrategy.processPayment(reservation.getTotalRent());
    }

    private boolean isCarAvailable(String carPlateNumber, LocalDate startDate, LocalDate endDate){
        for(Reservation reservation : reservationMap.values()){
            if(reservation.getCar().getPlateNumber().equals(carPlateNumber)){
                if(startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate()))
                    return false;
            }
        }
        return true;
    }
}
