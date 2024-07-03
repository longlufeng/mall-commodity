package com.llf.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.llf.client.dto.MerchantInfoDto;
import com.llf.client.vo.MerchantInfoVo;

@FeignClient("merchant")
public interface MerchantClient {
	
    @RequestMapping(value="/api/qryByMerchantId",method= RequestMethod.POST)
    MerchantInfoVo qryByMerchantId(MerchantInfoDto merchantInfoDto);

}
