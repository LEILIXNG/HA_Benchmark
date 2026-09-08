package com.habench.accountrefund.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VoucherMapper {

    List<Map<String, Object>> expand(@Param("ledgerEntry") String ledgerEntry);
}
