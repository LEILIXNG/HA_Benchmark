package com.habench.inventorynotice.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BatchMapper {

    List<Map<String, Object>> refine(@Param("batchTag") String batchTag);
}
