package haidar.springframework.msscbeerservice.services.impl;

import haidar.springframework.msscbeerservice.domain.Beer;
import haidar.springframework.msscbeerservice.repositories.BeerRepository;
import haidar.springframework.msscbeerservice.services.BeerService;
import haidar.springframework.msscbeerservice.web.mappers.BeerMapper;
import haidar.springframework.msscbeerservice.web.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDTO findById(UUID id) throws ChangeSetPersister.NotFoundException {
        return beerMapper.beerToBeerDto(beerRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    @Override
    public Beer saveNew(BeerDTO beerDTO) {
        return beerRepository.save(beerMapper.beerDtoToBeer(beerDTO));
    }

    @Override
    public void update(UUID id, BeerDTO beerDTO) throws ChangeSetPersister.NotFoundException {
        BeerDTO originalBeer = findById(id);
        log.debug("Update beer with id {}", id);
        originalBeer.setName(beerDTO.getName());
        originalBeer.setPrice(beerDTO.getPrice());
        originalBeer.setUpc(beerDTO.getUpc());
        originalBeer.setStyle(beerDTO.getStyle());
        originalBeer.setQuantityOnHand(beerDTO.getQuantityOnHand());
        beerRepository.save(beerMapper.beerDtoToBeer(originalBeer));
    }

    @Override
    public void delete(UUID id) {

    }
}
