package service;
public interface RoomService {
    void book(int roomNo);

    void checkIn(int roomNo);

    void checkOut(int roomNo);
}
