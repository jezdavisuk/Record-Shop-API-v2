package com.example.recordshopapiv2.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


public class Artist {

    Long artistId;

    String artistName;

    Set<Album> albums = new HashSet<>();

    Set<Stock> signedCopies = new HashSet<>();
}
