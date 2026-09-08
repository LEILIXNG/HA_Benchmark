package com.habench.billingrollup.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    List<Map<String, Object>> resolve(@Param("ledgerEntry") String ledgerEntry);
}
