package com.northwind.paymentverify.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 支付 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface InvoiceMapper {

    List<Map<String, Object>> route(@Param("tariffRef") String tariffRef);
}
