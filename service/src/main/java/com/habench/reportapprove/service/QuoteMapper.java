package com.habench.reportapprove.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QuoteMapper {

    List<Map<String, Object>> assemble(@Param("quoteRef") String quoteRef);
}
