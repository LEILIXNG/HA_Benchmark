package com.habench.inventorysplit.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManifestMapper {

    List<Map<String, Object>> dispatch(@Param("refundCode") String refundCode);
}
