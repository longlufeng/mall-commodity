package com.llf.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityImagePo {
	
	private String commodityId;
	private String url;
	private String createDate;
	private String createTime;
	private String updateDate;
	private String updateTime;

}
