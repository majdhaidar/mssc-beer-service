package haidar.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import haidar.springframework.msscbeerservice.services.BeerService;
import haidar.springframework.msscbeerservice.web.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

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

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void saveNew() throws Exception {
        BeerDTO beerDTO = BeerDTO.builder().build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson)).andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        BeerDTO beerDTO = BeerDTO.builder().build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDTO);
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON).content(beerDtoJson)).andExpect(status().isNoContent());
    }
}