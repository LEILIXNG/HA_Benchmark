package com.habench.paymentquote.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    List<Map<String, Object>> resolve(@Param("batchTag") String batchTag);
}
