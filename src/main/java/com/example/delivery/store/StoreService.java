package com.example.delivery.store;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    public Page<StoreResponseDto> getAllStores(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Store> storePage = storeRepository.finaAllStores(pageable);
        return storePage.map(storeMapper::toResponseDto);
    }
}
