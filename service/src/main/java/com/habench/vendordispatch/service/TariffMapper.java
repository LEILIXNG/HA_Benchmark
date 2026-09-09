package com.habench.vendordispatch.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TariffMapper {

    List<Map<String, Object>> submit(@Param("invoiceKey") String invoiceKey);
}
