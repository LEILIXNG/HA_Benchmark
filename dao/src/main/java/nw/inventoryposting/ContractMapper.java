package nw.inventoryposting;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 库存 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface ContractMapper {

    List<Map<String, Object>> forward(@Param("ledgerEntry") String ledgerEntry);
}
