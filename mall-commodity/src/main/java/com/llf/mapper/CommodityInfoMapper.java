package com.llf.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.llf.dto.CommodityInfoDelDto;
import com.llf.dto.CommodityInfoQryDto;
import com.llf.po.CommodityBaseInfoPo;
import com.llf.po.CommodityDetailInfoPo;
import com.llf.po.CommodityImagePo;
import com.llf.po.CommodityPricePo;

@Mapper
public interface CommodityInfoMapper {
	
	void addBase(CommodityBaseInfoPo commodityBaseInfoPo);
	
	void addDetail(CommodityDetailInfoPo commodityDetailInfoPo);
	
	void addImage(CommodityImagePo commodityImagePo);
	
	void addPrice(CommodityPricePo commodityPricePo);
	
	void delBase(@Param("commodityId") String commodityId);
	
	void delDetail(@Param("commodityId") String commodityId);
	
	void delImage(@Param("commodityId") String commodityId);
	
	void delPrice(@Param("commodityId") String commodityId);
	
	void updBase(CommodityBaseInfoPo commodityBaseInfoPo);
	
	void updDetail(CommodityDetailInfoPo commodityDetailInfoPo);

	void updImage(CommodityImagePo commodityImagePo);

	void updPrice(CommodityPricePo commodityPricePo);
	
	Map<String,Object> qryCommodityInfo(CommodityInfoQryDto commodityInfoQryDto);
	
	List<Map<String,Object>> qryList(CommodityInfoQryDto commodityInfoQryDto);

}
