package com.habench.paymentadjust.web;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BundleMapper {

    List<Map<String, Object>> resolve(@Param("accountRef") String accountRef);
}
