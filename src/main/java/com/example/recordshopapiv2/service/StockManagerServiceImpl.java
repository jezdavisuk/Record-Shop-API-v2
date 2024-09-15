package com.example.recordshopapiv2.service;

import com.example.recordshopapiv2.repository.StockManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockManagerServiceImpl implements StockManagerService {

    @Autowired
    StockManagerRepository stockManagerRepository;
}
