package com.habench.orderverify.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    List<Map<String, Object>> dispatch(@Param("catalogKey") String catalogKey);
}
