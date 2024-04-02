package haidar.springframework.msscbeerservice.web.mappers;

import haidar.springframework.msscbeerservice.domain.Beer;
import haidar.springframework.msscbeerservice.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO beerDTO);
    BeerDTO beerToBeerDto(Beer beer);

}
