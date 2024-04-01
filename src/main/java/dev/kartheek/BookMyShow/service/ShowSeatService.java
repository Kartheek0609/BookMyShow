package dev.kartheek.BookMyShow.service;

import dev.kartheek.BookMyShow.model.ShowSeat;
import dev.kartheek.BookMyShow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;
    public ShowSeat getShowSeat(int showSeatId){
        return showSeatRepository.findById(showSeatId).get();
    }
    public ShowSeat saveShowSeat(ShowSeat seat){
        return showSeatRepository.save(seat);
    }
}
