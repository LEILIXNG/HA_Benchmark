package com.habench.catalogexport.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShipmentMapper {

    List<Map<String, Object>> publish(@Param("tariffRef") String tariffRef);
}
