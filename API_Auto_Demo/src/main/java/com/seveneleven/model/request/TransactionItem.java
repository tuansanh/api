package com.seveneleven.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransactionItem {
    private int quantity;
    @JsonProperty("product_uom_id")
    private int productUomId;

    public TransactionItem(int quantity, int productUomId) {
        this.quantity = quantity;
        this.productUomId = productUomId;
    }
}
