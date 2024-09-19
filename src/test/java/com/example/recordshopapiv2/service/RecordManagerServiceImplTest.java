package com.example.recordshopapiv2.service;

import com.example.recordshopapiv2.repository.RecordManagerRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecordManagerServiceImplTest {

    @Mock
    private RecordManagerRepository mockRecordManagerRepository;

    @InjectMocks
    private RecordManagerServiceImpl recordManagerServiceImpl;

}