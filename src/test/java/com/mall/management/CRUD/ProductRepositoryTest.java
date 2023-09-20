package com.mall.management.CRUD;

import com.mall.management.Entity.Product;
import com.mall.management.Repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    //삽입테스트
    @Test
    public void testInsert() {
        Product product = Product.builder()
                .pname("테스트")
                .quan(1)
                .price(1000)
                .build();

        productRepository.save(product);
    }

    //검색테스트
    @Test
    public void findByIdTest() {
        int pno = 1;

        Optional<Product> result = productRepository.findById(pno);

        Product product = result.orElseThrow();
        log.info(product);
    }

    //수정테스트
    @Test
    public void testUpdate() {
        int pno = 2;
        Optional<Product> result = productRepository.findById(pno);
        if(result.isPresent()) {
            Product product = result.get();

            product.change("수정테스트",3,3000);

            productRepository.save(product);
        }
    }

    //삭제테스트
    @Test
    public void testDelete() {
        int pno = 1;
        productRepository.deleteById(pno);
    }


}
