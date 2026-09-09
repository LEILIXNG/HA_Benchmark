package com.northwind.billingnotice.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 账务 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface ContractMapper {

    List<Map<String, Object>> translate(@Param("invoiceKey") String invoiceKey);
}
