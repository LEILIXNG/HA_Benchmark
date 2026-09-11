package nw.accountrefund;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** 账户 明细的查询入口，语句在同名 XML 里维护。 */
@Mapper
public interface VoucherMapper {

    List<Map<String, Object>> expand(@Param("ledgerEntry") String ledgerEntry);
}
