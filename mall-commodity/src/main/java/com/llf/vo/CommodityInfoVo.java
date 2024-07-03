package com.llf.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityInfoVo {
	
	private String commodityId;
	private String commodityName;
	private String merchantId;
	private String merchantName;
	private String status;
	private String commodityType;
	private String commodityDesc;
	private String inventory;
	private String url;
	private String price;

}
