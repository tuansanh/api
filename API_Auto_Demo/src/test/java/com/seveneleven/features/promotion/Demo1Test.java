package com.seveneleven.features.promotion;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.seveneleven.api.promotion.PutSingleItemDiscount;
import com.seveneleven.builder.SingleTransactionBuilder;
import com.seveneleven.model.request.DataCSV;
import com.seveneleven.model.request.TransactionObject;
import com.seveneleven.utilities.CsvHelper;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;

public class Demo1Test {

	PutSingleItemDiscount promotionCal;

	@BeforeMethod
	public void setUp() {
		promotionCal = new PutSingleItemDiscount();
		 RestAssured.filters(new RequestLoggingFilter(LogDetail.BODY));
		 RestAssured.defaultParser = io.restassured.parsing.Parser.JSON;
	}

	// check status code
	@Test(dataProvider = "test1FieldHappy")
	public void checkStatus(DataCSV obj) {
		// set up data
		TransactionObject transaction = SingleTransactionBuilder.getTransactionBody(obj);
		// action
		Response response = promotionCal.callAPI(transaction);
		// compare data

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status code is " + statusCode);
	}

	// Happy case when apply 1 promotion
	@Test(dataProvider = "test1FieldHappy")
	public void test1(DataCSV obj) {
		// set up data
		TransactionObject transaction = SingleTransactionBuilder.getTransactionBody(obj);
		Response response = promotionCal.callAPI(transaction);
		String res = response.asString();
		System.out.println(res);
		int uom_id = JsonPath.read(res, "$.products[0].product_uom_id");
		System.out.println("Uom_id: "+uom_id);
		Assert.assertEquals(obj.getUom_id(), uom_id); // compare data

	}

	// data test 1 field HappyCase
	@DataProvider
	public static Object[][] test1FieldHappy() {
		return CsvHelper.fileTo2DArray("test1field_Happy.csv", DataCSV.class);
	}

	// data test 1 field UnHappyCase
	@DataProvider
	public static Object[][] test1fieldUnHappy() {
		return CsvHelper.fileTo2DArray("test1Field_UnHappy.csv", DataCSV.class);
	}

	// data test more than 1 field HappyCase
	@DataProvider
	public static Object[][] testMultiFieldsHappy() {
		return CsvHelper.fileTo2DArray("testmultifields_UnHappy.csv", DataCSV.class);
	}

	// data test more than 1 field UnHappyCase
	@DataProvider
	public static Object[][] testmultifieldsUnHappy() {
		return CsvHelper.fileTo2DArray("testmultifirlds_Happy.csv", DataCSV.class);
	}

}
