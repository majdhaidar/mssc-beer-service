package haidar.springframework.msscbeerservice.repositories;

import haidar.springframework.msscbeerservice.domain.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends CrudRepository<Beer, UUID>, PagingAndSortingRepository<Beer, UUID> {
}
