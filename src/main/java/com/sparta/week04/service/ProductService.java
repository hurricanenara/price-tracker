package com.sparta.week04.service;

import com.sparta.week04.models.ItemDto;
import com.sparta.week04.models.Product;
import com.sparta.week04.models.ProductMypriceRequestDto;
import com.sparta.week04.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Long update(Long id, ProductMypriceRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("No such id.")
        );
        product.update(requestDto);
        return id;
    }

    @Transactional
    public Long updateBySearch(Long id, ItemDto itemDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("No such id.")
        );
        product.updateByItemDto(itemDto);
        return id;
    }
}
