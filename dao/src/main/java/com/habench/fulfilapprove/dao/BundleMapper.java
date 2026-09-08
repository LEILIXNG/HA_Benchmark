package com.habench.fulfilapprove.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BundleMapper {

    List<Map<String, Object>> route(@Param("paymentTag") String paymentTag);
}
