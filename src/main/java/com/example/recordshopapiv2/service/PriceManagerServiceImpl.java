package com.example.recordshopapiv2.service;

import com.example.recordshopapiv2.repository.PriceManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceManagerServiceImpl implements PriceManagerService {

    @Autowired
    PriceManagerRepository priceManagerRepository;
}