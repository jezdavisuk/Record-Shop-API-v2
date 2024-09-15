package com.example.recordshopapiv2.repository;

import com.example.recordshopapiv2.data.Album;
import com.example.recordshopapiv2.data.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RecordManagerRepositoryTest {

    @Autowired
    RecordManagerRepository recordManagerRepository;
}
