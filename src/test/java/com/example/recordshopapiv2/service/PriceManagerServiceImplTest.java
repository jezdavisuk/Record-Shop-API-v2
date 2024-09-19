package com.example.recordshopapiv2.service;

import com.example.recordshopapiv2.repository.PriceManagerRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PriceManagerServiceImplTest {

    @Mock
    private PriceManagerRepository mockPriceManagerRepository;

    @InjectMocks
    private PriceManagerServiceImpl priceManagerServiceImpl;

}