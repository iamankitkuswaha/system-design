package serviceImpl;

import entity.Room;
import entity.RoomStatus;
import repository.InMemoryRepository;
import service.RoomService;

public class RoomServiceImpl implements RoomService {

    @Override
    public synchronized void book(int roomNo){
        Room room = InMemoryRepository.roomMap.get(roomNo);
        if(room.getRoomStatus() == RoomStatus.AVAILABLE){
            room.setRoomStatus(RoomStatus.BOOKED);
        }else{
            throw new IllegalStateException("entity.Room is not booked");
        }
    }

    @Override
    public synchronized void checkIn(int roomNo){
        Room room = InMemoryRepository.roomMap.get(roomNo);
        if(room.getRoomStatus() == RoomStatus.BOOKED){
            room.setRoomStatus(RoomStatus.OCCUPIED);
        }else{
            throw new IllegalStateException("entity.Room is not booked, can not be checked in!!");
        }
    }
    @Override
    public synchronized void checkOut(int roomNo){
        Room room =  InMemoryRepository.roomMap.get(roomNo);
        if(room.getRoomStatus() == RoomStatus.OCCUPIED){
            room.setRoomStatus(RoomStatus.AVAILABLE);
        }else{
            throw new IllegalStateException(roomNo+" is not occupied!!");
        }
    }
}
