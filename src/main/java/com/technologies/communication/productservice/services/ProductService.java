package com.technologies.communication.productservice.services;

import com.technologies.communication.productservice.repository.ProductRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.sample.proto.ProductRequest;
import org.springframework.grpc.sample.proto.ProductResponse;
import org.springframework.grpc.sample.proto.ProductServiceGrpc;
import org.springframework.stereotype.Service;



/**
 * @author : El-Merjani Mohamed
 * Date : 2/26/2025
 */
@Service
public class ProductService extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void getProductById(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        long productId = request.getId();
        var productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            var product = productOptional.get();
            System.out.println("Found product");
            ProductResponse response = ProductResponse.newBuilder()
                    .setId(product.getId())
                    .setName(product.getName())
                    .setPrice(product.getPrice())
                    .setAvailableStock(product.getAvailableStock())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {

            responseObserver.onError(new Throwable("Product not found"));
        }
    }
}
