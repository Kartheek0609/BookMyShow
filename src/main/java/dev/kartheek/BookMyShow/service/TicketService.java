package dev.kartheek.BookMyShow.service;

import dev.kartheek.BookMyShow.model.ShowSeat;
import dev.kartheek.BookMyShow.model.Ticket;
import dev.kartheek.BookMyShow.model.constant.ShowSeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private ShowSeatService showSeatService;
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void checkAndLockSeats(List<Integer> showSeatIds) throws Exception{
        for(int showSeatId: showSeatIds){
            ShowSeat seat =showSeatService.getShowSeat(showSeatId);
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new Exception("Seat is not available anymore");
            }
        }
        // updating the seats to a locked state
        for(int showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(seat);
        }
    }
    public boolean startPayment(List<Integer> showSeatId){
        return true;
    }

    public Ticket bookTicket(List<Integer> showSeatIds,int userId) throws Exception{
        checkAndLockSeats(showSeatIds);
        startPayment(showSeatIds);
        return new Ticket();
    }
    public String greet(){
        return "HELLO WORLD";
    }
}
