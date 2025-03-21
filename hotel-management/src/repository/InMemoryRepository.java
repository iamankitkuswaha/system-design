package repository;

import entity.Guest;
import entity.Reservation;
import entity.Room;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRepository {
    public static Map<Integer, Room>roomMap;
    public static Map<String, Reservation> reservationMap;
    public static Map<String, Guest> guestMap;

    public InMemoryRepository(){
        roomMap = new ConcurrentHashMap<>();
        reservationMap =  new ConcurrentHashMap<>();
        guestMap =  new ConcurrentHashMap<>();
    }
}
