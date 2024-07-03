package com.llf.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityDetailInfoPo {
	
	private String commodityId;
	private String commodityType;
	private String commodityDesc;
	private String inventory;
	private String createDate;
	private String createTime;
	private String updateDate;
	private String updateTime;

}
