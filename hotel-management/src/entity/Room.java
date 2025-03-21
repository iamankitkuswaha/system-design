package entity;

public class Room {
    private final int roomNo;
    private final RoomType roomType;
    private double rent;
    private RoomStatus roomStatus;

    public Room(int roomNo, RoomType roomType, double rent){
        this.roomNo  = roomNo;
        this.roomType = roomType;
        this.rent = rent;
        this.roomStatus = RoomStatus.AVAILABLE;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }
}
