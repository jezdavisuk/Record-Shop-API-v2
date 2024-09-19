package com.example.recordshopapiv2.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

import java.time.LocalDateTime;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock")
@Builder
public class Stock {

    @Id
    @GeneratedValue
    @Column(name="stock_id")
    Long stockId;

    @Column(name="format")
    @Enumerated(EnumType.STRING)
    Medium medium;

    @Column(name="quantity_in_stock")
    int quantityInStock;

    @Column(name="last_modified")
    LocalDateTime lastModified;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "artist_id")
    Artist artist;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "stock_id_to_artist_id",
            joinColumns = @JoinColumn(name = "stock_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    Set<Artist> signedBy;

}
