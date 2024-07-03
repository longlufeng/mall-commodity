package com.llf.servcie.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.llf.Enum.MerchantStatus;
import com.llf.client.InventoryClient;
import com.llf.client.MerchantClient;
import com.llf.client.dto.InventoryDto;
import com.llf.client.dto.MerchantInfoDto;
import com.llf.client.vo.InventoryVo;
import com.llf.client.vo.MerchantInfoVo;
import com.llf.dto.CommodityInfoAddDto;
import com.llf.dto.CommodityInfoDelDto;
import com.llf.dto.CommodityInfoQryDto;
import com.llf.dto.CommodityInfoUpdDto;
import com.llf.mapper.CommodityInfoMapper;
import com.llf.po.CommodityBaseInfoPo;
import com.llf.po.CommodityDetailInfoPo;
import com.llf.po.CommodityImagePo;
import com.llf.po.CommodityPricePo;
import com.llf.servcie.CommodityInfoService;
import com.llf.utils.DateUtil;
import com.llf.utils.GenerateStrUtil;
import com.llf.vo.CommodityInfoVo;

@Service
public class CommodityInfoServiceImpl implements CommodityInfoService{
	
	@Autowired
	CommodityInfoMapper commodityInfoMapper;
	
	@Autowired
	MerchantClient merchantClient;
	
	@Autowired
	InventoryClient inventoryClient;
	
	@Transactional( rollbackFor={Exception.class})
	public void add(CommodityInfoAddDto commodityInfoAddDto) {
		
		// 新增商品基本信息
		CommodityBaseInfoPo commodityBaseInfoPo = new CommodityBaseInfoPo();
		String commodityId = GenerateStrUtil.generateMercahntId();
		commodityBaseInfoPo.setCommodityId(commodityId);
		commodityBaseInfoPo.setCommodityName(commodityInfoAddDto.getCommodityName());
		// 商户Id从会话或者REDIS，建议从会话中取
		commodityBaseInfoPo.setMerchantId(commodityInfoAddDto.getMerchantId());
		commodityBaseInfoPo.setStatus(MerchantStatus.UP.getCode());
		commodityBaseInfoPo.setCreateDate(DateUtil.getCurDate());
		commodityBaseInfoPo.setCreateTime(DateUtil.getCurDateTime());
		commodityInfoMapper.addBase(commodityBaseInfoPo); 
		
		// 新增商品详细信息
		CommodityDetailInfoPo merchantDetailInfoPo = new CommodityDetailInfoPo();
		merchantDetailInfoPo.setCommodityId(commodityId);
		merchantDetailInfoPo.setCommodityType(commodityInfoAddDto.getCommodityType());
		merchantDetailInfoPo.setCommodityDesc(commodityInfoAddDto.getCommodityDesc());
		merchantDetailInfoPo.setInventory(commodityInfoAddDto.getInventory());
		merchantDetailInfoPo.setCreateDate(DateUtil.getCurDate());
		merchantDetailInfoPo.setCreateTime(DateUtil.getCurDateTime());
		commodityInfoMapper.addDetail(merchantDetailInfoPo);
		
		// 新增商品图像URL
		CommodityImagePo commodityImagePo = new CommodityImagePo();
		commodityImagePo.setCommodityId(commodityId);
		commodityImagePo.setUrl(commodityInfoAddDto.getUrl());
		commodityImagePo.setCreateDate(DateUtil.getCurDate());
		commodityImagePo.setCreateTime(DateUtil.getCurDateTime());
		commodityInfoMapper.addImage(commodityImagePo);
		
		// 新增商品价格信息
		CommodityPricePo CommodityPricePo = new CommodityPricePo();
		String commodityPriceId = GenerateStrUtil.generateMercahntId();
		CommodityPricePo.setCommodityPriceId(commodityPriceId);
		CommodityPricePo.setCommodityId(commodityId);
		CommodityPricePo.setPrice(commodityInfoAddDto.getPrice());
		CommodityPricePo.setStatus(MerchantStatus.UP.getCode());
		CommodityPricePo.setStartDate(DateUtil.getCurDate());
		CommodityPricePo.setEndDate(DateUtil.getCurDateMonthAgo(-1));
		CommodityPricePo.setCreateDate(DateUtil.getCurDate());
		CommodityPricePo.setCreateTime(DateUtil.getCurDateTime());
		commodityInfoMapper.addPrice(CommodityPricePo);
	}

	@Transactional( rollbackFor={Exception.class})
	public void del(CommodityInfoDelDto commodityInfoDelDto) {
		
		String commodityId = commodityInfoDelDto.getCommodityId();
		
		// 删除商品基本信息
		commodityInfoMapper.delBase(commodityId);
		
		// 删除商品详细信息
		commodityInfoMapper.delDetail(commodityId);
		
		// 删除商品图像信息
		commodityInfoMapper.delImage(commodityId);
		
		// 删除商品价格信息
		commodityInfoMapper.delPrice(commodityId);
		
	}

	@Transactional( rollbackFor={Exception.class})
	public void upd(CommodityInfoUpdDto commodityInfoUpdDto) {
		// 修改基本信息
		CommodityBaseInfoPo commodityBaseInfoPo = new CommodityBaseInfoPo();
		commodityBaseInfoPo.setCommodityId(commodityInfoUpdDto.getCommodityId());
		commodityBaseInfoPo.setCommodityName(commodityInfoUpdDto.getCommodityName());
		commodityBaseInfoPo.setUpdateDate(DateUtil.getCurDate());
		commodityBaseInfoPo.setUpdateTime(DateUtil.getCurDateTime());
		commodityInfoMapper.updBase(commodityBaseInfoPo);
		
		// 修改详细信息
		CommodityDetailInfoPo commodityDetailInfoPo = new CommodityDetailInfoPo();
		commodityDetailInfoPo.setCommodityId(commodityInfoUpdDto.getCommodityId());
		commodityDetailInfoPo.setCommodityDesc(commodityInfoUpdDto.getCommodityDesc());
		commodityDetailInfoPo.setInventory(commodityInfoUpdDto.getInventory());
		commodityDetailInfoPo.setUpdateDate(DateUtil.getCurDate());
		commodityDetailInfoPo.setUpdateTime(DateUtil.getCurDateTime());
		commodityInfoMapper.updDetail(commodityDetailInfoPo);
		
		// 修改图片信息
		CommodityImagePo commodityImagePo = new CommodityImagePo();
		commodityImagePo.setCommodityId(commodityInfoUpdDto.getCommodityId());
		commodityImagePo.setUrl(commodityInfoUpdDto.getUrl());
		commodityImagePo.setUpdateDate(DateUtil.getCurDate());
		commodityImagePo.setUpdateTime(DateUtil.getCurDateTime());
		commodityInfoMapper.updImage(commodityImagePo);
		
		// 修改价格信息
		CommodityPricePo commodityPricePo = new CommodityPricePo();
		commodityPricePo.setCommodityId(commodityInfoUpdDto.getCommodityId());
		commodityPricePo.setPrice(commodityInfoUpdDto.getPrice());
		commodityPricePo.setUpdateDate(DateUtil.getCurDate());
		commodityPricePo.setUpdateTime(DateUtil.getCurDateTime());
		commodityInfoMapper.updPrice(commodityPricePo);
		
	}

	public CommodityInfoVo qrySingle(CommodityInfoQryDto commodityInfoQryDto) {
		
		CommodityInfoVo commodityInfoVo = new CommodityInfoVo();
		
		// 1.查询商品信息
		Map<String,Object> commodityInfoMap = commodityInfoMapper.qryCommodityInfo(commodityInfoQryDto);
		try {
			// map转换为实体类
			BeanUtils.populate(commodityInfoVo, commodityInfoMap);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		// 2.查询商户信息
		MerchantInfoDto merchantInfoDto = new MerchantInfoDto();
		merchantInfoDto.setMerchantId(commodityInfoQryDto.getMerchantId());
		MerchantInfoVo merchantInfoVo = merchantClient.qryByMerchantId(merchantInfoDto);
		commodityInfoVo.setMerchantName(merchantInfoVo.getMerchantName());
		
		// 3.查询库存
		InventoryDto inventoryDto = new InventoryDto();
		inventoryDto.setMerchantId(commodityInfoQryDto.getMerchantId());
		inventoryDto.setComodityId(commodityInfoQryDto.getCommodityId());
		InventoryVo inventoryVo = inventoryClient.qryInventory(inventoryDto);
		commodityInfoVo.setInventory(inventoryVo.getNumber());
		
		return commodityInfoVo;
	}

	public List<Map<String,Object>> qryList(CommodityInfoQryDto commodityInfoQryDto) {
		List<Map<String,Object>> resList = commodityInfoMapper.qryList(commodityInfoQryDto);
		if(resList == null || resList.isEmpty()) {
			return new ArrayList<Map<String,Object>>();
		}
		
		for(Map<String,Object> map : resList) {
			map.put("statusDesc", MerchantStatus.getMerStatusByCode(map.get("status").toString()).getDesc());
		}
		
		return resList;
	}

}
