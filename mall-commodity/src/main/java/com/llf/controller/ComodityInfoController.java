package com.llf.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llf.dto.CommodityInfoAddDto;
import com.llf.dto.CommodityInfoDelDto;
import com.llf.dto.CommodityInfoQryDto;
import com.llf.dto.CommodityInfoUpdDto;
import com.llf.servcie.CommodityInfoService;
import com.llf.utils.ResultPackage;
import com.llf.vo.CommodityInfoVo;


@RestController
@RequestMapping("/commodity")
public class ComodityInfoController {
	
	@Autowired
	CommodityInfoService commodityInfoService;
	
	@RequestMapping("/add")
	public ResultPackage add(HttpServletRequest request,@RequestBody CommodityInfoAddDto commodityInfoAddDto){
		
		HttpSession session = request.getSession();
		commodityInfoAddDto.setMerchantId(session.getAttribute("loginMerchantId").toString());
		commodityInfoService.add(commodityInfoAddDto);
		
		return ResultPackage.success();
	}
	
	@RequestMapping("/del")
	public ResultPackage del(@RequestBody CommodityInfoDelDto commodityInfoDelDto){
		
		commodityInfoService.del(commodityInfoDelDto);
		
		return ResultPackage.success();
	}
	
	@RequestMapping("/upd")
	public ResultPackage upd(@RequestBody CommodityInfoUpdDto commodityInfoUpdDto){
		
		commodityInfoService.upd(commodityInfoUpdDto);
		
		return ResultPackage.success();
	}
	
	@RequestMapping("/qryById")
	public ResultPackage qryById(@RequestBody CommodityInfoQryDto commodityInfoQryDto){
		
		CommodityInfoVo commodityInfoVo = commodityInfoService.qrySingle(commodityInfoQryDto);
		
		return ResultPackage.success(commodityInfoVo);
	}
	
	@RequestMapping("/qryList")
	public ResultPackage qryList(@RequestBody CommodityInfoQryDto commodityInfoQryDto){
		
		List<Map<String,Object>> resList = commodityInfoService.qryList(commodityInfoQryDto);
		
		return ResultPackage.success(resList);
	}
	
}
