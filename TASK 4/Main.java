import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private String category;
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserve() {
        isAvailable = false;
    }

    public void release() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

class Reservation {
    private Room room;
    private String customerName;

    public Reservation(Room room, String customerName) {
        this.room = room;
        this.customerName = customerName;
    }

    public Room getRoom() {
        return room;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "room=" + room +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}

class HotelReservationSystem {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public HotelReservationSystem() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single", 100));
        rooms.add(new Room(102, "Double", 150));
        rooms.add(new Room(201, "Suite", 300));
        rooms.add(new Room(202, "Suite", 300));
        rooms.add(new Room(301, "Deluxe", 200));
    }

    public void searchRooms(String category) {
        System.out.println("Available rooms in category " + category + ":");
        for (Room room : rooms) {
            if (room.isAvailable() && room.getCategory().equalsIgnoreCase(category)) {
                System.out.println(room);
            }
        }
    }

    public void makeReservation(int roomNumber, String customerName) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.reserve();
                Reservation reservation = new Reservation(room, customerName);
                reservations.add(reservation);
                System.out.println("Reservation successful: " + reservation);
                return;
            }
        }
        System.out.println("Room not available or does not exist.");
    }

    public void viewReservations() {
        System.out.println("Current Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HotelReservationSystem hotel = new HotelReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Search Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter room category to search (Single/Double/Suite/Deluxe): ");
                    String category = scanner.nextLine();
                    hotel.searchRooms(category);
                    break;
                case 2:
                    System.out.print("Enter room number to reserve: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    hotel.makeReservation(roomNumber, customerName);
                    break;
                case 3:
                    hotel.viewReservations();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    scanner.close();
            }
        }
    }
}
