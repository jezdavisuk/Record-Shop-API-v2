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

    @Column(name="wholesale_price")
    BigDecimal wholesalePrice;

    @Column(name="market_price")
    BigDecimal marketPrice;

    @OneToOne(mappedBy = "price")
    private Stock stock;

//    @JsonIgnore
//    @Column(name="profit_margin")
//    BigDecimal profitMargin = getProfitMargin();
//
//    @JsonIgnore
//    BigDecimal getProfitMargin() {
//        assert wholesalePrice != null;
//        return wholesalePrice.subtract(marketPrice);
//    }
}
