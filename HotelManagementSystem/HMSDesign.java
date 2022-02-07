import java.util.Date;
import java.util.List;

public class HMSDesign {

    class Hotel {
        String name;
        Integer id;
        Location hotelLocation;
        List <Room> roomList;
    }

    static class Location {
        Double longitude;
        Double latitude;
    }

    class Room {
        String roomNumber;
        RoomStyle roomStyle;
        RoomStatus roomStatus;
        Double bookingPrice;
        List<RoomKey> roomKeys;
        List<HouseKeepingLog> houseKeepingLogs;

    }

    public enum RoomStyle {
        STANDARD, DELUX, FAMILY_SUITE;
    }

    public enum RoomStatus {
        AVAILABLE, RESERVED, NOT_AVAILBLE, OCCUPIED, SERVICE_IN_PROGRESS;
    }

    public enum BookingStatus {
        REQUESTED, PENDING, CONFIRMED, CHECKED_IN, CHECKED_OUT, CANCELLED, ABANDONED
    }

    class RoomKey {
        String keyId;
        String barCode;
        Date issuedAt;
        Boolean isActive;
        Boolean isMaster;

        public void assignRoom(Room room) {
         // logic
        }
    }

    class HouseKeepingLog {
        String description;
        Date startDate;
        int duration;
        HouseKeeper houskeeper;

        public void addRoom(Room room) {
            //logic
        }
    }

    abstract class Person {
        String name;
        Account accountDetail;
        String phone;
    }

    public class Account {
        String username;
        String password;

        AccountStatus accountStatus;

    }

    public enum AccountStatus {
        ACTIVE, CLOSED, BLOCKED;
    }

    class HouseKeeper extends Person {

        public List <Room> getRoomsServiced(Date date) {
            return null;
        }
    }

    class Guest extends Person {

        Search searchObj;
        Booking bookingObj;

        public List <RoomBooking> getAllRoomBookings() {
            return null;
        }

        public RoomBooking createBooking() {
            return null;
        }

        public RoomBooking cancelBooking(int bookingId) {
            return null;
        }
    }

    class Receptionist extends Person {
        Search searchObj;
        Booking bookingObj;

        public void checkInGuest(Guest guest, RoomBooking bookingInfo) {
        }

        public void checkOutGuest(Guest guest, RoomBooking bookingInfo) {

        }

    }

    class Admin extends Person {
        public void addRoom(Room roomDetail) {

        }

        public Room deleteRoom(String roomId) {
            return null;
        }

        public void editRoom(Room roomDetail) {
        }
    }

    class Search {
        public List <Room> searchRoom(RoomStyle roomStyle, Date startDate, int duration) {
               return null;
        }

    }

    class RoomBooking {
        String bookingId;
        Date startDate;
        int durationInDays;
        BookingStatus bookingStatus;
        List<Guest> guestList;
        List<Room> roomInfo;
        BaseRoomCharge totalRoomCharges;
    }


    /**
     *	Decorator pattern is used to decorate the prices here.
     **/

    interface BaseRoomCharge {
        Double getCost();
    }

    class RoomCharge implements BaseRoomCharge {
        double cost;
        public Double getCost() {
            return cost;
        }
        void setCost(double cost) {
            this.cost = cost;
        }
    }

    class RoomServiceCharge implements BaseRoomCharge {
        double cost;
        BaseRoomCharge baseRoomCharge;
        public Double getCost() {
            // baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
            return baseRoomCharge.getCost();
        }
    }

    class InRoomPurchaseCharges implements BaseRoomCharge {
        double cost;
        BaseRoomCharge baseRoomCharge;
        public Double getCost() {
//            baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
            return baseRoomCharge.getCost();
        }
    }

    class Booking {
        public RoomBooking createBooking(Guest guestInfo) {
            return null;
        }

        public RoomBooking cancelBooking(int bookingId) {
            return null;
        }
    }

}
