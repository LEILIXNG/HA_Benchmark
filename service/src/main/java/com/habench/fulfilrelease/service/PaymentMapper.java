package com.habench.fulfilrelease.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    List<Map<String, Object>> expand(@Param("catalogKey") String catalogKey);
}
