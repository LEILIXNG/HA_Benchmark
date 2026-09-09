package com.northwind.vendormerge.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 供应商 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface CatalogMapper {

    List<Map<String, Object>> translate(@Param("invoiceKey") String invoiceKey);
}
