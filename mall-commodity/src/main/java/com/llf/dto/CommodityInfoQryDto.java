package com.llf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityInfoQryDto {
	
	private String merchantId;
	private String commodityId;
	private String commodityName;
	private String status;
	private String startDate;
	private String endDate;
	private String minPrice;
	private String maxPrice;

}
