package com.habench.paymentreopen.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VoucherMapper {

    List<Map<String, Object>> submit(@Param("shipmentCode") String shipmentCode);
}
