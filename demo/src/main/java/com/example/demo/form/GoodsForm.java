package com.example.demo.form;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class GoodsForm {
	private Integer goodsId;
	private Character fanType;
	private Character counterHandoverFrag;
	private Timestamp counterHandoverDate;
}
