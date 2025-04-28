package org.example.bookmyshow.controller;

import org.example.bookmyshow.dtos.IssueTicketRequestDto;
import org.example.bookmyshow.dtos.IssueTicketResponseDto;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.Booking;
import org.example.bookmyshow.service.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto) throws Exception {
        IssueTicketResponseDto responseDto = new IssueTicketResponseDto();
        Booking booking;

        try {
            // passing data from requestDto directly to service class method
            booking = bookingService.issueTicket(requestDto.getUserId(), requestDto.getShowId(), requestDto.getShowSeatIds());

            responseDto.setBookingId(booking.getId());
            responseDto.setAmount(booking.getAmount());
        }catch(Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

}
