package com.example.demo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "goods")
@Data
public class Goods {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GOODS_ID")
	private Integer goodsId;
	

	@Column(name = "FAN_TYPE")
	private Character FAN_TYPE;
	

	@Column(name = "COUNTER_HANDOVER_FRAG")
	private Character COUNTER_HANDOVER_FRAG;
	
	@Column(name = "COUNTER_HANDOVER_DATE")
	private Timestamp COUNTER_HANDOVER_DATE;
	
	@Column(name = "CREATED_AT", insertable = false, updatable = false)
	private Timestamp CREATED_AT;
	
	@Column(name = "UPDATED_AT", insertable = false, updatable = false)
	private Timestamp UPDATED_AT;
}
