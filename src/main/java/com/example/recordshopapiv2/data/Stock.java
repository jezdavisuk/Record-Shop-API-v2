package com.example.recordshopapiv2.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock")
@Builder
public class Stock {

    Long stockId;

    Album album;

    Medium medium;

    int stockCount;

    Price retailPrice;

    LocalDateTime lastModified;

    Set<Artist> signedBy;

}
