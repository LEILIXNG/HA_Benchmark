package com.habench.billingintake.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InvoiceMapper {

    List<Map<String, Object>> forward(@Param("quoteRef") String quoteRef);
}
