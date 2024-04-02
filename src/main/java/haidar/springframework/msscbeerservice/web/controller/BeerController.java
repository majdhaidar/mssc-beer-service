package haidar.springframework.msscbeerservice.web.controller;

import haidar.springframework.msscbeerservice.domain.Beer;
import haidar.springframework.msscbeerservice.services.BeerService;
import haidar.springframework.msscbeerservice.web.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer/")
@Slf4j
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("{id}")
    public ResponseEntity<BeerDTO> findById(@PathVariable("id") UUID id) {
        BeerDTO result = beerService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNew(@RequestBody @Validated BeerDTO beerDTO) {
        Beer savedBeer = beerService.saveNew(beerDTO);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Location", "/api/v1/beer/".concat(savedBeer.getId().toString()));
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody @Validated BeerDTO beerDTO) {
        beerService.update(id, beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") UUID id){
        beerService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
