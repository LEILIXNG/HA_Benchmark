package com.northwind.pricingreview.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 定价 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface ReceiptMapper {

    List<Map<String, Object>> resolve(@Param("paymentTag") String paymentTag);
}
