package haidar.springframework.msscbeerservice.bootstrap;

import haidar.springframework.msscbeerservice.domain.Beer;
import haidar.springframework.msscbeerservice.repositories.BeerRepository;
import haidar.springframework.msscbeerservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            saveBeer("corona", BeerStyleEnum.IPA, 12330001231L, 22, 1000, 12);
            saveBeer("almaza", BeerStyleEnum.IPA, 7666481L, 20, 150, 2);
            saveBeer("beirut beer", BeerStyleEnum.IPA, 6627391231L, 15, 10000, 177);
        }
    }

    private void saveBeer(String beerName, BeerStyleEnum beerStyle, long beerUpc, int beerPrice, int beerQuantityToBrew, int beerMinOnHand) {
        beerRepository.save(Beer.builder().name(beerName).style(beerStyle).upc(beerUpc).price(BigDecimal.valueOf(beerPrice)).quantityOnHand(beerQuantityToBrew).minOnHand(beerMinOnHand).build());
    }
}
