package dev.kartheek.BookMyShow.model;

import dev.kartheek.BookMyShow.model.constant.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private LocalDateTime timeOfBooking;
    private double amount;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Show show;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

}
