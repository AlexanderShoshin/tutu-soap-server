package shoshin.alex.tutusoap.data;

import java.util.Calendar;

public class Ticket {
//    примитив уже будет 0 при инициализации
    private static int lastId = 0;
    private int id;
    private String destinationPoint;
    private String departurePoint;
    private Calendar destinationTime;
    private Calendar departureTime;
    private Price price;
    private TicketStatus status;
    private Passenger passenger;

//    как портатип ок. Но в идеале было бы, чтобы тикет не сам себя инициализировал, а былы бы некая фабрика тикетов.
//    она бы как раз и знала, с каким id, статусом и т.п. создавать объект
    public Ticket() {
        lastId++;
        id = lastId;
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
    public Price getPrice() {
        return price;
    }
    public void setPrice(Price price) {
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