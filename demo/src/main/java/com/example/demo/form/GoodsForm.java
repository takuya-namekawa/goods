package com.example.demo.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class GoodsForm {
	private Integer goodsId;
	private Character fanType;
	private Character counterHandoverFrag;
	private LocalDate counterHandoverDate;
}
