package com.northwind.reportapprove.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 报表 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface QuoteMapper {

    List<Map<String, Object>> assemble(@Param("quoteRef") String quoteRef);
}
