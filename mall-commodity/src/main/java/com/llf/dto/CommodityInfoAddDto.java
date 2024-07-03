package com.llf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityInfoAddDto {
	
	private String merchantId;
	private String commodityName;
	private String commodityType;
	private String commodityDesc;
	private String inventory;
	private String url;
	private String price;

}
