package com.habench.vendorapprove.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReceiptMapper {

    List<Map<String, Object>> reconcile(@Param("invoiceKey") String invoiceKey);
}
