package nw.orderverify;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 订单 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface PaymentMapper {

    List<Map<String, Object>> dispatch(@Param("catalogKey") String catalogKey);
}
