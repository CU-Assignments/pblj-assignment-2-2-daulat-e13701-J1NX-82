import java.util.*;
class TicketBookingSystem {
 private int availableSeats;
 private Set<Integer> bookedSeats;
 public TicketBookingSystem(int totalSeats) {
 this.availableSeats = totalSeats;
 this.bookedSeats = new HashSet<>();
 }
 public synchronized boolean bookSeat(int seatNumber, String user) {
 if (bookedSeats.contains(seatNumber)) {
 System.out.println(user + " attempted to book Seat " + seatNumber + ", but it's already
taken!");
 return false;
 } else {
 bookedSeats.add(seatNumber);
 System.out.println(user + " successfully booked Seat " + seatNumber);
 return true;
 }
 }
}
class User extends Thread {
 private TicketBookingSystem system;
 private int seatNumber;
 private String userName;
 public User(TicketBookingSystem system, int seatNumber, String userName, int priority) {
 this.system = system;
 this.seatNumber = seatNumber;
 this.userName = userName;
 setPriority(priority);
 }
 @Override
 public void run() {
 system.bookSeat(seatNumber, userName);
 }
}
public class TicketBookingMain {
 public static void main(String[] args) {
 TicketBookingSystem bookingSystem = new TicketBookingSystem(5);
 User u1 = new User(bookingSystem, 1, "VIP_User1", Thread.MAX_PRIORITY);
 User u2 = new User(bookingSystem, 2, "Regular_User1", Thread.NORM_PRIORITY);
 User u3 = new User(bookingSystem, 3, "VIP_User2", Thread.MAX_PRIORITY);
 User u4 = new User(bookingSystem, 1, "Regular_User2", Thread.NORM_PRIORITY);
 User u5 = new User(bookingSystem, 4, "VIP_User3", Thread.MAX_PRIORITY);
 User u6 = new User(bookingSystem, 5, "Regular_User3", Thread.NORM_PRIORITY);
 u1.start();
 u2.start();
 u3.start();
 u4.start();
 u5.start();
 u6.start();
 }
}
