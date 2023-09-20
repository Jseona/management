package com.mall.management.Service;

import com.mall.management.DTO.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ProductServiceTest {
    //서비스는 자료와 결과값이 DTO로 구성
    @Autowired
    private ProductSerice productSerice;

    //삽입테스트
    @Test
    public void testInsert() {
        ProductDTO productDTO = ProductDTO.builder()
                .pname("서비스 테스트")
                .quan(3)
                .price(3000)
                .build();
        productSerice.insert(productDTO);
    }

    //삭제테스트
    @Test
    public void delete() {
        int pno = 3;
        productSerice.delete(pno);
    }

    //수정테스트
    @Test
    public void testUpdate() {
        ProductDTO productDTO = ProductDTO.builder()
                .pno(4)
                .pname("서비스 수정")
                .quan(4)
                .price(4000)
                .build();
        productSerice.update(productDTO);
    }

    //검색테스트
    @Test
    public void testFindAll() {
        System.out.println(productSerice.findAll());
    }

}
