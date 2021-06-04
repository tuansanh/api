package com.seveneleven.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionPromotionsObject {
    @JsonProperty("promotion_code")
    private String promotionCode;
    @JsonProperty("promotion_name")
    private String promotionName;
}
