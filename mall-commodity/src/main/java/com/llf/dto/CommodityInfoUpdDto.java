package com.llf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityInfoUpdDto {
	
	private String commodityId;
	private String commodityName;
	private String commodityDesc;
	private String inventory;
	private String url;
	private String price;

}
