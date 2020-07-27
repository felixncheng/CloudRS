package io.github.chengmboy.cloudrs.order.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDTO {

    private String productCode;

    private BigDecimal money;

    private Integer count;
}
