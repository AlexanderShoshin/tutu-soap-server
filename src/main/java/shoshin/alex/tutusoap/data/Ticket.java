package shoshin.alex.tutusoap.data;

import java.util.Calendar;
import java.util.Random;

public class Ticket {
    private int id;
    private String destinationPoint;
    private String departurePoint;
    private Calendar destinationTime;
    private Calendar departureTime;
    private int price;
    private TicketStatus status;
    private Passenger passenger;
    
    public Ticket() {
        Random rnd = new Random();
        id = rnd.nextInt();
        status = TicketStatus.RESERVED;
    }
    
    public int getId() {
        return id;
    }
    public String getDestinationPoint() {
        return destinationPoint;
    }
    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }
    public String getDeparturePoint() {
        return departurePoint;
    }
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }
    public Calendar getDestinationTime() {
        return destinationTime;
    }
    public void setDestinationTime(Calendar destinationTime) {
        this.destinationTime = destinationTime;
    }
    public Calendar getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Calendar departureTime) {
        this.departureTime = departureTime;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public TicketStatus getStatus() {
        return status;
    }
    public void setStatus(TicketStatus status) {
        this.status = status;
    }
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}