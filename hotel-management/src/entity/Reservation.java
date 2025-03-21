package entity;

import entity.Guest;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    private final String id;
    private Room room;
    private Guest guest;
    private ReservationStatus reservationStatus;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    public Reservation(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate){
        this.id = getReservationId();
        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.reservationStatus = ReservationStatus.CONFIRMED;
    }

    public String getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    private String getReservationId() {
        // Generate a unique reservation ID
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
