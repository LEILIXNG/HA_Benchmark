package com.habench.pricingreview.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReceiptMapper {

    List<Map<String, Object>> resolve(@Param("paymentTag") String paymentTag);
}
