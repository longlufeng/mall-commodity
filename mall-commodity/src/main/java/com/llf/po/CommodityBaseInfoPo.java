package com.llf.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityBaseInfoPo {
	
	private String commodityId;
	private String commodityName;
	private String merchantId;
	private String status;
	private String createDate;
	private String createTime;
	private String updateDate;
	private String updateTime;
	private String deleteFlag;

}
