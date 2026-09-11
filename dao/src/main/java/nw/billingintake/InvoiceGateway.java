package nw.billingintake;

import nw.platform.MapperSessions;
import nw.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;

/**
 * 账务明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class InvoiceGateway {

    public static void translate(String value) {
        try (SqlSession session = MapperSessions.open(InvoiceMapper.class)) {
            collect(session.getMapper(InvoiceMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void collect(InvoiceMapper mapper, String value) {
        mapper.forward(value);
    }
}
