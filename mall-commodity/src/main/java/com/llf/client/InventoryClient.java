package com.llf.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.llf.client.dto.InventoryDto;
import com.llf.client.vo.InventoryVo;

@FeignClient("inventory")
public interface InventoryClient {
	
    @RequestMapping(value="/api/inventory/qryInventory",method= RequestMethod.POST)
    InventoryVo qryInventory(InventoryDto inventoryDto);

}
