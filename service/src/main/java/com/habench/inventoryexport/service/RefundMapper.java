package com.habench.inventoryexport.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RefundMapper {

    List<Map<String, Object>> prepare(@Param("orderRef") String orderRef);
}
