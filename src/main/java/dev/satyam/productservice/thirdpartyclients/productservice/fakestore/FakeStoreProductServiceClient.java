package dev.satyam.productservice.thirdpartyclients.productservice.fakestore;

import dev.satyam.productservice.dtos.GenericProductDto;
import dev.satyam.productservice.exceptions.NotFoundException;
//import lombok.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
@Service
public class FakeStoreProductServiceClient {
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductApiPath;
    private String productRequestBaseUrl;
    private String productRequestSpecificUrl;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}") String fakeStoreApiUrl,
                                         @Value("${fakestore.api.paths.product}") String fakeStoreProductApiPath){
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestBaseUrl = fakeStoreApiUrl + fakeStoreProductApiPath;
        this.productRequestSpecificUrl = fakeStoreApiUrl + fakeStoreProductApiPath + "/{id}";
    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(productRequestSpecificUrl, FakeStoreProductDto.class, id);
        //response.getStatusCode();
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if(fakeStoreProductDto == null){
            throw new NotFoundException("product id "+id+" does not exists");
        }
        return fakeStoreProductDto;
    }


    public FakeStoreProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(productRequestBaseUrl,
                product, FakeStoreProductDto.class);

        return response.getBody();
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestBaseUrl,
                FakeStoreProductDto[].class);

        return Arrays.asList(response.getBody());
    }
    public FakeStoreProductDto deleteProductById(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(productRequestSpecificUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);


        return response.getBody();
    }
}
