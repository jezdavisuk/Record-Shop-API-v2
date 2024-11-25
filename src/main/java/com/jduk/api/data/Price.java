package com.jduk.api.data;

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
    @Column(name = "price_id")
    Long priceId;

    @Column(name="wholesale_price")
    BigDecimal wholesalePrice;

    @Column(name="market_price")
    BigDecimal marketPrice;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @PrimaryKeyJoinColumn(name = "stock", referencedColumnName = "stock_id")
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
