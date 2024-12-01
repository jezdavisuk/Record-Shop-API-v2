package com.jduk.api.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

    @Column(name="FORMAT")
    @Enumerated(EnumType.STRING)
    private Medium medium;

    @Column(name="QUANTITY_IN_STOCK", nullable = false)
    private int quantityInStock;

    @Column(name="LAST_MODIFIED")
    private LocalDateTime lastModified;

    @OneToOne
    @JoinColumn(name = "PRICE_ID", referencedColumnName = "ID", nullable = false)
    private Price price;

}
