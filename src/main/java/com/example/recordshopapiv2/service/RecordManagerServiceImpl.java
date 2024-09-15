package com.example.recordshopapiv2.service;

import com.example.recordshopapiv2.repository.RecordManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordManagerServiceImpl implements RecordManagerService {

    @Autowired
    RecordManagerRepository recordManagerRepository;
}
