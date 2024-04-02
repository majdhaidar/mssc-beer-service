package haidar.springframework.msscbeerservice.services.impl;

import haidar.springframework.msscbeerservice.domain.Beer;
import haidar.springframework.msscbeerservice.services.BeerService;
import haidar.springframework.msscbeerservice.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO findById(UUID id) {
        return BeerDTO.builder().build();
    }

    @Override
    public Beer saveNew(BeerDTO beerDTO) {

        return Beer.builder().id(UUID.randomUUID()).name(beerDTO.getName()).style(beerDTO.getStyle()).build();
    }

    @Override
    public void update(UUID id, BeerDTO beerDTO) {

    }

    @Override
    public void delete(UUID id) {

    }
}
