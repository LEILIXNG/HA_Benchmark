package com.northwind.paymentarchive.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 支付 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface SessionMapper {

    List<Map<String, Object>> publish(@Param("accountRef") String accountRef);
}
