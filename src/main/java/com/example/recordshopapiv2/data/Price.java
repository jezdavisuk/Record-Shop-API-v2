package com.example.recordshopapiv2.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "price")
@Builder
public class Price {

    @Id
    @Column(name="stock_id")
    Long id;

    // relationship three
    @OneToOne
    @MapsId
    @JoinColumn(name = "stock_id")
    Stock stock;

    @Column(name="wholesale_price", nullable = false)
    BigDecimal wholesalePrice;

    @Column(name="market_price", nullable = false)
    BigDecimal marketPrice;

    @JsonIgnore
    @Column(name="profit_margin")
    BigDecimal profitMargin = getProfitMargin();

    @JsonIgnore
    BigDecimal getProfitMargin() {
        assert wholesalePrice != null;
        return wholesalePrice.subtract(marketPrice);
    }

}
