package haidar.springframework.msscbeerservice.services;

import haidar.springframework.msscbeerservice.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO findById(UUID id);

    BeerDTO saveNew(BeerDTO beerDTO);

    void update(UUID id, BeerDTO beerDTO);

    void delete(UUID id);
}
