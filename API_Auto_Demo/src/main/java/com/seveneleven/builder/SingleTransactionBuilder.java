package com.seveneleven.builder;

import java.util.Arrays;
import java.util.Collections;

import com.seveneleven.model.request.DataCSV;
import com.seveneleven.model.request.DataCSV2;
import com.seveneleven.model.request.TransactionItem;
import com.seveneleven.model.request.TransactionObject;

public class SingleTransactionBuilder {

	public static TransactionObject getTransactionBody(DataCSV obj) {

		TransactionItem item = new TransactionItem(obj.getQuantity(), obj.getUom_id());

		TransactionObject transaction = new TransactionObject().setTransactionItems(Collections.singletonList(item))
				.setPromotionVouchers(Collections.emptyList()).setStoreId(obj.getStore_id()).setPaymentMethodId(100)
				.setOrderId("test");
		return transaction;
	}

	
}
