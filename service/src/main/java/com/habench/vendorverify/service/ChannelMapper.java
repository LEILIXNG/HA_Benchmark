package com.habench.vendorverify.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChannelMapper {

    List<Map<String, Object>> translate(@Param("tariffRef") String tariffRef);
}
