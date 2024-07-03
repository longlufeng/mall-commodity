package com.llf.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryVo {
	
	private String merchantId;
	private String comodityId;
	private String number;
	private String createDate;
	private String createTime;
	private String updateDate;
	private String updateTime;

}
