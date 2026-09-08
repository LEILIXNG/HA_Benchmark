package com.habench.billinglookup.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContractMapper {

    List<Map<String, Object>> prepare(@Param("refundCode") String refundCode);
}
