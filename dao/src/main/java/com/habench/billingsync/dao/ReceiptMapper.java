package com.habench.billingsync.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReceiptMapper {

    List<Map<String, Object>> enrich(@Param("catalogKey") String catalogKey);
}
