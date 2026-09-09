package com.northwind.inventorydraft.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 库存 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface InvoiceMapper {

    List<Map<String, Object>> submit(@Param("accountRef") String accountRef);
}
