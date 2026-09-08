package com.habench.cataloglookup.web;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShipmentMapper {

    List<Map<String, Object>> enrich(@Param("shipmentCode") String shipmentCode);
}
