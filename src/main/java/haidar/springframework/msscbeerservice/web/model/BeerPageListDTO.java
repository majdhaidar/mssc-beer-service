package haidar.springframework.msscbeerservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerPageListDTO extends PageImpl<BeerDTO> {
    public BeerPageListDTO(List<BeerDTO> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPageListDTO(List<BeerDTO> content) {
        super(content);
    }
}
