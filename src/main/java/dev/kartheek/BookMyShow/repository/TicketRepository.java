package dev.kartheek.BookMyShow.repository;

import dev.kartheek.BookMyShow.model.ShowSeat;
import dev.kartheek.BookMyShow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
