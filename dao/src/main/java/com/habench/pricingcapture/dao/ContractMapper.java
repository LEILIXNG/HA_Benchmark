package com.habench.pricingcapture.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContractMapper {

    List<Map<String, Object>> collect(@Param("catalogKey") String catalogKey);
}
