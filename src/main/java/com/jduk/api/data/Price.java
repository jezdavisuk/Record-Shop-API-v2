package com.jduk.api.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    @Column(name = "ID")
    private Long priceId;

    @Column(name="WHOLESALE_PRICE")
    BigDecimal wholesalePrice;

    @Column(name="MARKET_PRICE")
    BigDecimal marketPrice;

    @OneToOne(mappedBy = "price")
    private Stock stock;

//    @Column(name="profit_margin")
//    BigDecimal profitMargin = getProfitMargin();
//
//    BigDecimal getProfitMargin() {
//        assert wholesalePrice != null;
//        return wholesalePrice.subtract(marketPrice);
//    }
}
