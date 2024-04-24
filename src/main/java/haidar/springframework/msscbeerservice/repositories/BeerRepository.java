package haidar.springframework.msscbeerservice.repositories;

import haidar.springframework.msscbeerservice.domain.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BeerRepository extends CrudRepository<Beer, UUID>, PagingAndSortingRepository<Beer, UUID> {
}
