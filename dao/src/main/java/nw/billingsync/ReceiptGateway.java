package nw.billingsync;

import nw.platform.MapperSessions;
import nw.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;

/**
 * 账务受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ReceiptGateway {

    public static void dispatch(String value) {
        try (SqlSession session = MapperSessions.open(ReceiptMapper.class)) {
            merge(session.getMapper(ReceiptMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void merge(ReceiptMapper mapper, String value) {
        mapper.enrich(value);
    }
}
