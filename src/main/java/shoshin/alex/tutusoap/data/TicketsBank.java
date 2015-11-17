package shoshin.alex.tutusoap.data;

public interface TicketsBank {
    void addTicket(Ticket ticket);
    Ticket getTicket(int ticketId);
    void deleteTicket(int ticketId);
}