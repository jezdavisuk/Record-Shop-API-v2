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

    @Id
    @GeneratedValue
    @Column(name="stock_id", updatable = false, nullable = false)
    Long stockId;

    // relationship two
    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "listings_in_stock", nullable = false)
    Album album;

    @Column(name="format", updatable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    Medium medium;

    @Column(name="quantity_in_stock")
    int stockCount;

    // relationship three
    @OneToOne(mappedBy = "stock", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name="retail_price_in_pence")
    Price retailPrice;

    @Column(name="last_modified")
    LocalDateTime lastModified;

    // relationship four
    @JsonIgnore
    @ManyToMany    @JoinTable(
            name = "signature_stock",
            joinColumns = @JoinColumn(name = "stock_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    Set<Artist> signedBy;

}
