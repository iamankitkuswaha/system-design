import entity.*;
import payment.CashPayment;
import payment.PaymentStrategy;
import repository.InMemoryRepository;
import service.ReservationService;
import service.RoomService;
import serviceImpl.HotelManagementService;
import serviceImpl.ReservationServiceImpl;
import serviceImpl.RoomServiceImpl;

import java.time.LocalDate;

public class HotelManagementSystem {
    public static void main(String[] args) {

        RoomService  roomService = new RoomServiceImpl();
        ReservationService reservationService = new ReservationServiceImpl(roomService);
        HotelManagementService hotelManagementService = HotelManagementService.getInstance(reservationService);

        Room room1 =  new Room(1, RoomType.DOUBLE, 1000);
        Room room2 = new Room(2, RoomType.SINGLE, 2000);

        Guest guest1 = new Guest("g1","Ankit","ankit@example.com");
        Guest guest2 = new Guest("g2","Durgesh", "durgesh@example.com");

        hotelManagementService.addRoom(room1);
        hotelManagementService.addRoom(room2);

        hotelManagementService.addGuest(guest1);
        hotelManagementService.addGuest(guest2);

        LocalDate checkInDate = LocalDate.now();
        LocalDate checkOutDate =  checkInDate.plusDays(3);

        Reservation reservation1 = hotelManagementService.doReservation(room1, guest1, checkInDate, checkOutDate);
        if(reservation1!=null){
            System.out.println("Room "+reservation1.getRoom().getRoomNo()+" reserved: "+reservation1.getId());
        }else{
            System.out.printf("Room is not available!!!");
        }

        hotelManagementService.checkIn(reservation1.getId());
        System.out.println("Room "+reservation1.getRoom().getRoomNo()+" checked in: "+reservation1.getId());

        PaymentStrategy paymentStrategy =  new CashPayment();
        hotelManagementService.checkOut(reservation1.getId(), paymentStrategy);
        System.out.println("Room "+reservation1.getRoom().getRoomNo()+" checked out: "+ reservation1.getId());

        hotelManagementService.cancelReservation(reservation1.getId());
        System.out.println("Reservation cancelled: "+ reservation1.getId());
    }
}