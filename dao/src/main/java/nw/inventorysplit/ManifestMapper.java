package nw.inventorysplit;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 库存 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface ManifestMapper {

    List<Map<String, Object>> dispatch(@Param("refundCode") String refundCode);
}
