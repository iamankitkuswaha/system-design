package serviceImpl;

import entity.Guest;
import entity.Reservation;
import entity.Room;
import payment.PaymentStrategy;
import repository.InMemoryRepository;
import service.ReservationService;

import java.time.LocalDate;

public class HotelManagementService {
    private static HotelManagementService hotelManagementService;
    private ReservationService reservationService;
    private InMemoryRepository inMemoryRepository;
    private HotelManagementService(ReservationService  reservationService){
        this.reservationService = reservationService;
        inMemoryRepository = new InMemoryRepository();
    }

    public static HotelManagementService getInstance(ReservationService reservationService){
        if(hotelManagementService==null)
            hotelManagementService =  new HotelManagementService(reservationService);
        return hotelManagementService;
    }

    public void addGuest(Guest guest){
        InMemoryRepository.guestMap.put(guest.getId(), guest);
        System.out.println(guest.getName()+" registered!!");
    }

    public void addRoom(Room room){
        InMemoryRepository.roomMap.put(room.getRoomNo(), room);
        System.out.println("Room "+room.getRoomNo()+" ready for service!!!");
    }

    public Room getRoom(int roomNo){
        return InMemoryRepository.roomMap.get(roomNo);
    }

    public Guest getGuest(String guestId){
        return InMemoryRepository.guestMap.get(guestId);
    }

    public Reservation doReservation(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate){
        return reservationService.doReservation(room, guest, checkInDate, checkOutDate);
    }

    public void cancelReservation(String reservationId){
        reservationService.cancelReservation(reservationId);
    }

    public void checkIn(String reservationId){
        reservationService.checkIn(reservationId);
    }

    public void checkOut(String reservationId, PaymentStrategy paymentStrategy){
        reservationService.checkOut(reservationId, paymentStrategy);
    }
}
