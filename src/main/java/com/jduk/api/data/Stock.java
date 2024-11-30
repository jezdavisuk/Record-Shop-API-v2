package com.jduk.api.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.util.Set;

import java.time.LocalDateTime;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STOCK")
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", updatable = false, nullable = false)
    private Long stockId;

    @Column(name="format")
    @Enumerated(EnumType.STRING)
    Medium medium;

    @Column(name="quantity_in_stock")
    int quantityInStock;

    @Column(name="last_modified")
    LocalDateTime lastModified;

    @OneToOne
    @JoinColumn(name = "PRICE_ID", referencedColumnName = "ID", nullable = false)
    private Price price;

//    @ManyToOne
//    @JoinColumn(name = "artist_id", referencedColumnName = "artist_id")
//    Artist artist;

//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "stock_id_to_artist_id",
//            joinColumns = @JoinColumn(name = "stock_id"),
//            inverseJoinColumns = @JoinColumn(name = "artist_id")
//    )
//    Set<Artist> signedBy;

}
