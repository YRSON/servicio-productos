package com.challenge.backend.productos.service;

import com.challenge.backend.productos.Model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> productDataBase = new ArrayList<>(List.of(
            new Product(1L, "Papaya", 2.50),
            new Product(2L, "Mandarina", 2.0),
            new Product(3L, "Fresa", 3.50)
    ));

    public Flux<Product> findAll(){
        return Flux.fromIterable(productDataBase);
    }

    public Mono<Product> findById(Long id){
        return Flux.fromIterable(productDataBase)
                .filter(p -> p.id().equals(id))
                .next();
    }

}
