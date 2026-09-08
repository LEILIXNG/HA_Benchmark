package com.habench.billingtransfer.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CatalogMapper {

    List<Map<String, Object>> register(@Param("tariffRef") String tariffRef);
}
