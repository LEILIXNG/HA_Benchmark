package com.habench.fulfilissue.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    List<Map<String, Object>> collect(@Param("refundCode") String refundCode);
}
