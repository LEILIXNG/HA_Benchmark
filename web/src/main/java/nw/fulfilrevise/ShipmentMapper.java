package nw.fulfilrevise;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 履约 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface ShipmentMapper {

    List<Map<String, Object>> stage(@Param("voucherRef") String voucherRef);
}
