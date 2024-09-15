package com.example.recordshopapiv2.controller;

import com.example.recordshopapiv2.service.StockManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stock")
public class StockManagerController {

    @Autowired
    StockManagerService stockManagerService;
}
