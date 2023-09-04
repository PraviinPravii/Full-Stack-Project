package controllers;


import dtos.GenerateTicketRequestDTO;
import dtos.GenerateTicketResponseDTO;
import dtos.ResponseStatus;
import models.Ticket;
import strategies.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO requestDTO){
        GenerateTicketResponseDTO responseDTO = null;

        try {
            Ticket ticket = ticketService.generateTicket(requestDTO);

            responseDTO.setGeneratedTicketId(ticket.getId());
            responseDTO.setStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Ticket generated successfully");
        } catch(Exception ex){
            responseDTO.setStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(ex.getMessage());
            // ideally don't give exception message, might leak application details
            // log it, give the client id of log
        }

        return responseDTO;
    }

}
