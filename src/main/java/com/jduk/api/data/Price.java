package com.jduk.api.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRICE")
public class Price implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long priceId;

    @Column(name="WHOLESALE_PRICE")
    private BigDecimal wholesalePrice;

    @Column(name="MARKET_PRICE")
    private BigDecimal marketPrice;

    @OneToOne(mappedBy = "price")
    private Stock stock;

    @Transient
    private BigDecimal profitMargin = getProfitMargin();

    @Transient
    private BigDecimal getProfitMargin() {
        assert wholesalePrice != null;
        return wholesalePrice.subtract(marketPrice);
    }
}
