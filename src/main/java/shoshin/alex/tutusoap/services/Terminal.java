package shoshin.alex.tutusoap.services;

import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import shoshin.alex.tutusoap.data.Passenger;
import shoshin.alex.tutusoap.data.SimpleTicketsBank;
import shoshin.alex.tutusoap.data.Ticket;
import shoshin.alex.tutusoap.data.TicketStatus;
import shoshin.alex.tutusoap.data.TicketsBank;
import shoshin.alex.tutusoap.errors.AlreadyPaidException;
import shoshin.alex.tutusoap.errors.ChangeStatusException;
import shoshin.alex.tutusoap.errors.TicketDoesNotExistException;
import shoshin.alex.tutusoap.utils.TicketCalculator;

@WebService
public class Terminal {

    private TicketsBank bank = new SimpleTicketsBank();
    
    @WebMethod(operationName = "reserveTicket")
    public int reserveTicket(@WebParam(name = "name") String name,
                             @WebParam(name = "surname") String surname,
                             @WebParam(name = "patronymic") String patronymic,
                             @WebParam(name = "birthDate") Calendar birthDate,
                             @WebParam(name = "departurePoint") String departurePoint,
                             @WebParam(name = "destinationPoint") String destinationPoint,
                             @WebParam(name = "departureTime") Calendar departureTime,
                             @WebParam(name = "destinationTime") Calendar destinationTime) {
        
        Passenger passenger = new Passenger(name,
                                            surname,
                                            patronymic,
                                            birthDate);
        Ticket ticket = createNewTicket(passenger,
                                        destinationPoint,
                                        departurePoint,
                                        destinationTime,
                                        departureTime);
        bank.addTicket(ticket);
        return ticket.getId();
    }
    
    private Ticket createNewTicket(Passenger passenger,
                                   String destinationPoint,
                                   String departurePoint,
                                   Calendar destinationTime,
                                   Calendar departureTime) {
        Ticket ticket = new Ticket();
        ticket.setPassenger(passenger);
        ticket.setDestinationPoint(destinationPoint);
        ticket.setDeparturePoint(departurePoint);
        ticket.setDestinationTime(destinationTime);
        ticket.setDepartureTime(departureTime);
        ticket.setPrice(TicketCalculator.getDefaultPrice());
        return ticket;
    }
    
    @WebMethod(operationName="getTicket")
    public Ticket getTicket(@WebParam(name = "ticketId") int ticketId) {
        return bank.getTicket(ticketId);
    }
    
    @WebMethod(operationName="payForTicket")
    public void payForTicket(@WebParam(name = "ticketId") int ticketId) throws TicketDoesNotExistException, AlreadyPaidException {
        try {
            changeTicketStatus(ticketId, TicketStatus.PAID);
        } catch (NullPointerException exc) {
            throw new TicketDoesNotExistException();
        } catch (ChangeStatusException exc) {
            throw new AlreadyPaidException();
        }
    }
    
    private void changeTicketStatus(int ticketId, TicketStatus status) throws ChangeStatusException {
        Ticket ticket = bank.getTicket(ticketId);
        if (ticket.getStatus().equals(status)) {
            throw new ChangeStatusException();
        }
        ticket.setStatus(TicketStatus.PAID);
    }
    
    @WebMethod(operationName="returnTicket")
    public void returnTicket(@WebParam(name = "ticketId") int ticketId) {
        bank.deleteTicket(ticketId);
    }
}