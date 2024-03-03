package haidar.springframework.msscbeerservice.web.controller;

import haidar.springframework.msscbeerservice.services.BeerService;
import haidar.springframework.msscbeerservice.web.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeerDTO> findById(@PathVariable("id") UUID id) {
        BeerDTO result = beerService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNew(@RequestBody BeerDTO beerDTO){
        beerService.saveNew(beerDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") UUID id,
                                 @RequestBody BeerDTO beerDTO){
        beerService.update(id, beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
