package com.northwind.vendordispatch.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 供应商 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface TariffMapper {

    List<Map<String, Object>> submit(@Param("invoiceKey") String invoiceKey);
}
