package com.habench.vendoradjust.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InvoiceMapper {

    List<Map<String, Object>> attach(@Param("invoiceKey") String invoiceKey);
}
