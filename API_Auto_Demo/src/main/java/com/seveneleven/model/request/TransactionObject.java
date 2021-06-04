package com.seveneleven.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TransactionObject {
    @JsonProperty("transaction_items")
    private List<TransactionItem> transactionItems;
    @JsonProperty("promotion_vouchers")
    private List<PromotionVoucher> promotionVouchers;
    @JsonProperty("store_id")
    private int storeId;
    @JsonProperty("payment_method_id")
    private int paymentMethodId;
    @JsonProperty("order_id")
    private String orderId;

    public TransactionObject setTransactionItems(List<TransactionItem> transactionItems) {
        this.transactionItems = transactionItems;
        return this;
    }

    public TransactionObject setPromotionVouchers(List<PromotionVoucher> promotionVouchers) {
        this.promotionVouchers = promotionVouchers;
        return this;
    }

    public TransactionObject setStoreId(int storeId) {
        this.storeId = storeId;
        return this;
    }

    public TransactionObject setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
        return this;
    }

    public TransactionObject setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }
}
