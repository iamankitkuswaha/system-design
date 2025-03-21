package serviceImpl;

import entity.*;
import payment.PaymentStrategy;
import repository.InMemoryRepository;
import service.ReservationService;
import service.RoomService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReservationServiceImpl implements ReservationService {

    private RoomService roomService;
    public ReservationServiceImpl(RoomService roomService){
        this.roomService = roomService;
    }
    @Override
    public Reservation doReservation(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate){
        if(room.getRoomStatus() == RoomStatus.AVAILABLE){
            roomService.book(room.getRoomNo());
            Reservation reservation =  new Reservation(room, guest, checkInDate, checkOutDate);
            InMemoryRepository.reservationMap.put(reservation.getId(), reservation);
            return reservation;
        }
        return null;
    }
    @Override
    public void checkIn(String reservationId){
        Reservation reservation =  InMemoryRepository.reservationMap.get(reservationId);
        if(reservation!=null && reservation.getReservationStatus() == ReservationStatus.CONFIRMED){
            roomService.checkIn(reservation.getRoom().getRoomNo());
        }else{
            throw new IllegalStateException("Reservation is not confirmed or not a valid reservation");
        }
    }
    @Override
    public void checkOut(String reservationId, PaymentStrategy paymentStrategy){
        Reservation reservation = InMemoryRepository.reservationMap.get(reservationId);
        if(reservation!=null && reservation.getReservationStatus() == ReservationStatus.CONFIRMED){
            Room room =  reservation.getRoom();
            double amount = room.getRent()*(ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate()));
            if(paymentStrategy.processPayment(amount)){
                roomService.checkOut(reservation.getRoom().getRoomNo());
                InMemoryRepository.reservationMap.remove(reservationId);
            }else{
                throw new IllegalStateException("Payment failed!!");
            }
        }else{
            throw new IllegalStateException("Reservation is not confirmed or not a valid reservation.");
        }
    }
    @Override
    public void cancelReservation(String reservationId){
        Reservation reservation = InMemoryRepository.reservationMap.get(reservationId);
        if(reservation!=null && reservation.getReservationStatus() == ReservationStatus.CONFIRMED){
            reservation.setReservationStatus(ReservationStatus.CANCELLED);
            roomService.checkOut(reservation.getRoom().getRoomNo());
            InMemoryRepository.reservationMap.remove(reservationId);
        }
    }
}
