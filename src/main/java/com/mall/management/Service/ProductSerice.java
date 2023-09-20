package com.mall.management.Service;

import com.mall.management.DTO.ProductDTO;
import com.mall.management.Entity.Product;
import com.mall.management.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductSerice {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public ProductDTO findByPno(int pno) {
        Optional<Product> result = productRepository.findById(pno);
        return result.isPresent()?entityTodto(result.get()):null;
    }

    public int insert(ProductDTO productDTO) {
        Product entity = dtoToEntity(productDTO);
        productRepository.save(entity);
        return entity.getPno();
    }

    public void update(ProductDTO productDTO) {
        Optional<Product> result = productRepository.findById(productDTO.getPno());
        if(result.isPresent()) {
            Product entity = result.get();
            entity.changePname(productDTO.getPname());
            entity.changePquan(productDTO.getQuan());
            entity.changePrice(productDTO.getPrice());

            productRepository.save(entity);
        }
    }

    public void delete(int pno) {
        productRepository.deleteById(pno);
    }

    Product dtoToEntity(ProductDTO productDTO) {
        Product entity = Product.builder()
                .pno(productDTO.getPno())
                .pname(productDTO.getPname())
                .quan(productDTO.getQuan())
                .price(productDTO.getPrice())
                .pdate(productDTO.getPdate())
                .build();
        return entity;
    }

    ProductDTO entityTodto(Product product) {
        ProductDTO dto = ProductDTO.builder()
                .pno(product.getPno())
                .pname(product.getPname())
                .quan(product.getQuan())
                .price(product.getPrice())
                .pdate(product.getPdate())
                .build();
        return dto;
    }

}
