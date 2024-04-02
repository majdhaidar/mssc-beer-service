package haidar.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import haidar.springframework.msscbeerservice.domain.Beer;
import haidar.springframework.msscbeerservice.services.BeerService;
import haidar.springframework.msscbeerservice.web.model.BeerDTO;
import haidar.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    BeerDTO validBeerDTO;

    @BeforeEach
    void setUp(){
        validBeerDTO =  BeerDTO.builder()
                .name("Almaza")
                .style(BeerStyleEnum.IPA)
                .upc(12332123L)
                .price(BigDecimal.valueOf(122))
                .build();
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void saveNew() throws Exception {
        String beerDtoJson = objectMapper.writeValueAsString(validBeerDTO);
        Beer savedBeer = Beer.builder().id(UUID.randomUUID()).name(validBeerDTO.getName()).style(validBeerDTO.getStyle()).build();
        given(beerService.saveNew(any())).willReturn(savedBeer);
        mockMvc.perform(post("/api/v1/beer/").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson)).andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        String beerDtoJson = objectMapper.writeValueAsString(validBeerDTO);
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON).content(beerDtoJson)).andExpect(status().isNoContent());
    }
}