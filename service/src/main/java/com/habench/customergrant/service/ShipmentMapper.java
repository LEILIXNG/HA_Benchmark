package com.habench.customergrant.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShipmentMapper {

    List<Map<String, Object>> merge(@Param("receiptKey") String receiptKey);
}
