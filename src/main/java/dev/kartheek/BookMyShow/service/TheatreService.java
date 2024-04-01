package dev.kartheek.BookMyShow.service;

import dev.kartheek.BookMyShow.model.City;
import dev.kartheek.BookMyShow.model.Theatre;
import dev.kartheek.BookMyShow.repository.CityRepository;
import dev.kartheek.BookMyShow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private CityService cityService;
    public Theatre  saveTheatre(String name, String address, int cityId){
        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        Theatre savedTheatre= theatreRepository.save(theatre);
        City city = new City();
        List<Theatre> theatres= city.getTheatres();
        theatres.add(savedTheatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);
        return savedTheatre;
    }
}
