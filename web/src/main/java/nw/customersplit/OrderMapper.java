package nw.customersplit;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 客户 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface OrderMapper {

    List<Map<String, Object>> translate(@Param("quoteRef") String quoteRef);
}
