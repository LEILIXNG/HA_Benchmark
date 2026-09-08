package com.habench.paymentlookup.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SessionMapper {

    List<Map<String, Object>> merge(@Param("ledgerEntry") String ledgerEntry);
}
