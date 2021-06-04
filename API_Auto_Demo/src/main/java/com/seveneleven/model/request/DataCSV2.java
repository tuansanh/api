package com.seveneleven.model.request;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class DataCSV2 {
    @CsvBindByName
    private int id;
    @CsvBindByName
    private int uom_id;
    @CsvBindByName
    private int quantity;
    @CsvBindByName
    private int uom_id_2;
    @CsvBindByName
    private int quantity_2;
    @CsvBindByName
    private int promotion_id;
    @CsvBindByName
    private String promotion_name;
    @CsvBindByName
    private int store_id;
    @CsvBindByName
    private int amount_before;
    @CsvBindByName
    private int discount_amount;
    @CsvBindByName
    private int amount_after;
}
