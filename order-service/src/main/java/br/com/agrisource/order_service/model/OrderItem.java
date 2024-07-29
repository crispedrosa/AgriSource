package br.com.agrisource.order_service.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderItem {

    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal price;
}
