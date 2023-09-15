package dev.satyam.productservice.services;

import dev.satyam.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import dev.satyam.productservice.dtos.GenericProductDto;
import dev.satyam.productservice.exceptions.NotFoundException;
import dev.satyam.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    private GenericProductDto convertFakeStoreProductToGenericProduct(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        return product;
    }
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return convertFakeStoreProductToGenericProduct(
                fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return convertFakeStoreProductToGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreProductServiceClient.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            genericProductDtos.add(convertFakeStoreProductToGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtos;
    }
    public GenericProductDto deleteProductById(Long id){
        return convertFakeStoreProductToGenericProduct(fakeStoreProductServiceClient.deleteProductById(id));
    }
}
