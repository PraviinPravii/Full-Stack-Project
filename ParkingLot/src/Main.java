import controllers.TicketController;
import dtos.GenerateTicketRequestDTO;
import strategies.TicketService;

public class Main {
    public static void main(String[] args) {
        TicketService ts = new TicketService();
        TicketController tc = new TicketController(ts);
//        tc.generateTicket(?,?,?);
        System.out.println("Hello world!");
    }

}