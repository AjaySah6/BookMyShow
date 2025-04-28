package org.example.bookmyshow.dtos;

import lombok.Data;
import org.example.bookmyshow.dtos.ResponseStatus;


// return type of issueTicket is Booking,
// so the IssueTicketResponseDto should have all the attributes as of Booking


@Data
public class IssueTicketResponseDto {
    private ResponseStatus responseStatus;
    private int amount;
    private Long bookingId;
}
