package com.example.recordshopapiv2.service;

import com.example.recordshopapiv2.repository.RecordManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RecordManagerServiceImpl implements RecordManagerService {

    @Autowired
    RecordManagerRepository recordManagerRepository;
}
