import entity.Car;
import entity.Customer;
import entity.Reservation;
import repository.InMemoryRepository;
import service.CarService;
import service.CustomerService;
import service.ReservationService;

import java.time.LocalDateTime;
import java.util.List;

public class CarRentalSystem {
    public static void main(String[] args) {
        InMemoryRepository inMemoryRepository = InMemoryRepository.getInstance();
        CarService carService = new CarService(inMemoryRepository);
        ReservationService reservationService = ReservationService.getInstance(inMemoryRepository, carService);
        CustomerService customerService = new CustomerService(inMemoryRepository);


        // Create customers
        Customer c1 = new Customer("C1","Ankit","DL_123","46549589765");
        customerService.addCustomer(c1);

        // add cars
        Car car1 = new Car("UP-15-AB1234","Toyota", "Innova",200.0);
        Car car2 = new Car("UP-82-AB1243","Maruti Suzuki", "Swift",100.0);
        Car car3 = new Car("UP-81-AB1432","Hyundai", "Creta",100.0);
        Car car4 = new Car("UP-35-AB4321","Tata Motors", "Punch",100.0);
        carService.addCar(car1);
        carService.addCar(car2);
        carService.addCar(car3);
        carService.addCar(car4);

        // Make reservation
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plusDays(3);
        List<Car>availableCars =  reservationService.searchCars("Tata Motors","Punch", startDate, endDate);
        if(!availableCars.isEmpty()){
            Car car = availableCars.get(0);
            Reservation reservation = reservationService.makeReservation(c1, car, startDate, endDate);
            if(reservation!=null){
                boolean payment = reservationService.processPayment(reservation);
                if(payment){
                    System.out.println("Resrevation done, reservation ID: "+reservation.getId());
                }else{
                    System.out.println("Payment failed!!");
                }
            }else{
                System.out.println("Selected car is not available for given time period");
            }
        }else{
            System.out.println("Car is not available for given details!!");
        }
    }
}