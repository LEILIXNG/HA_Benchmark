package com.habench.ordertrace.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QuoteMapper {

    List<Map<String, Object>> reconcile(@Param("refundCode") String refundCode);
}
