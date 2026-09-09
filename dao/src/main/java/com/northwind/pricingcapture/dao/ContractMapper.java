package com.northwind.pricingcapture.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 定价 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface ContractMapper {

    List<Map<String, Object>> collect(@Param("catalogKey") String catalogKey);
}
