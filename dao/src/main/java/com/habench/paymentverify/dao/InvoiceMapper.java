package com.habench.paymentverify.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InvoiceMapper {

    List<Map<String, Object>> route(@Param("tariffRef") String tariffRef);
}
