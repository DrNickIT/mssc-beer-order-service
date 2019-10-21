package guru.sfg.beer.order.service.services.beer;

import guru.sfg.beer.order.service.services.beer.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class BeerServiceImpl implements BeerService {
    private static final String BEER_BY_UPC_PATH = "/api/v1/beer/beerUpc/";
    private static final String BEER_BY_ID = "/api/v1/beer/";
    private final RestTemplate restTemplate;
    private String beerServiceHost;

    public BeerServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public void setBeerServiceHost(String beerServiceHost) {
        this.beerServiceHost = beerServiceHost;
    }

    @Override
    public Optional<BeerDto> getBeerByUpc(String upc) {
        return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_BY_UPC_PATH + upc, BeerDto.class));
    }

    @Override
    public Optional<BeerDto> getBeerById(UUID beerId) {
        return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_BY_ID + beerId, BeerDto.class));
    }
}
