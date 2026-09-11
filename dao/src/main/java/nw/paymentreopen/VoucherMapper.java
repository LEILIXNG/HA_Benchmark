package nw.paymentreopen;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 支付 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface VoucherMapper {

    List<Map<String, Object>> submit(@Param("shipmentCode") String shipmentCode);
}
