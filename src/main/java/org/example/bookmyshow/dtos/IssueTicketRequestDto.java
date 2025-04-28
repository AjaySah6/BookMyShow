package org.example.bookmyshow.dtos;

import lombok.Data;

import java.util.List;
// will take the same parameter that issueTicket (); takes in service class

@Data // Getter + Setter
public class IssueTicketRequestDto { // will take the same parameter that issueTicket (); takes in service class
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;
}
