package com.habench.inventoryposting.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContractMapper {

    List<Map<String, Object>> forward(@Param("ledgerEntry") String ledgerEntry);
}
