package com.seveneleven.api.promotion;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.seveneleven.utilities.LoadConfig.CONFIG;

import com.seveneleven.model.request.TransactionObject;

public class PutSingleItemDiscount {

	public Response callAPI(TransactionObject object) {
		return RestAssured.given().contentType(ContentType.JSON)
				.header("Authorization", "Bearer 75773721-5ef3-4d41-a611-2fbf87af6f52").body(object)
				.put(CONFIG.getProperty("baseUrl") + "api/v2/reward/hq-portal/promotions/cal");
	}

	
}
