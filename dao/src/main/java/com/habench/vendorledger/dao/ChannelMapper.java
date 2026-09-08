package com.habench.vendorledger.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChannelMapper {

    List<Map<String, Object>> attach(@Param("tariffRef") String tariffRef);
}
