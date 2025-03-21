package service;

import entity.*;
import payment.PaymentStrategy;
import repository.InMemoryRepository;
import serviceImpl.RoomServiceImpl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public interface ReservationService {

    Reservation doReservation(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate);
    void checkIn(String reservationId);

    void checkOut(String reservationId, PaymentStrategy paymentStrategy);

    void cancelReservation(String reservationId);
}
