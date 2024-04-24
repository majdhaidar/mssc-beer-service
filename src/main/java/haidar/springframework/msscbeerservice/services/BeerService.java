package haidar.springframework.msscbeerservice.services;

import haidar.springframework.msscbeerservice.domain.Beer;
import haidar.springframework.msscbeerservice.web.model.BeerDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.UUID;

public interface BeerService {
    BeerDTO findById(UUID id) throws ChangeSetPersister.NotFoundException;

    Beer saveNew(BeerDTO beerDTO);

    void update(UUID id, BeerDTO beerDTO) throws ChangeSetPersister.NotFoundException;

    void delete(UUID id);
}
