package com.northwind.inventorynotice.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 库存 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface BatchMapper {

    List<Map<String, Object>> refine(@Param("batchTag") String batchTag);
}
