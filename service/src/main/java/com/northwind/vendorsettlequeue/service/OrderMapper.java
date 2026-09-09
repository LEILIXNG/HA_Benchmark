package com.northwind.vendorsettlequeue.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 供应商 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface OrderMapper {

    List<Map<String, Object>> collect(@Param("batchTag") String batchTag);
}
