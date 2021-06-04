package com.seveneleven.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentObject {
    @JsonProperty("transaction_promotions")
    private List<TransactionPromotionsObject> transactionPromotions;

}
