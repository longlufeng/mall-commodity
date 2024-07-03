package com.llf.servcie;

import java.util.List;
import java.util.Map;

import com.llf.dto.CommodityInfoAddDto;
import com.llf.dto.CommodityInfoDelDto;
import com.llf.dto.CommodityInfoQryDto;
import com.llf.dto.CommodityInfoUpdDto;
import com.llf.vo.CommodityInfoVo;

public interface CommodityInfoService {
	
	void add(CommodityInfoAddDto merchantInfoAddDto);
	
	void del(CommodityInfoDelDto commodityInfoDelDto);
	
	void upd(CommodityInfoUpdDto commodityInfoUpdDto);
	
	CommodityInfoVo qrySingle(CommodityInfoQryDto commodityInfoQryDto);
	
	List<Map<String,Object>> qryList(CommodityInfoQryDto commodityInfoQryDto);

}
