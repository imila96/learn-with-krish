package net.javaguides.orderservice.repository;

import net.javaguides.basedomains.dto.Products;
import net.javaguides.basedomains.dto.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface OrderRepository extends MongoRepository<Products,String> {
    public List<Products> findOrderByorderId(String orderId);
}

