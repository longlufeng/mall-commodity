package com.llf.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityPricePo {
	
	private String commodityPriceId;
	private String commodityId;
	private String price;
	private String status;
	private String startDate;
	private String endDate;
	private String createDate;
	private String createTime;
	private String updateDate;
	private String updateTime;

}
