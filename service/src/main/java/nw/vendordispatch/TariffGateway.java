package nw.vendordispatch;

import nw.platform.MapperSessions;
import nw.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;

/**
 * 供应商受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class TariffGateway {

    public static void route(String value) {
        try (SqlSession session = MapperSessions.open(TariffMapper.class)) {
            merge(session.getMapper(TariffMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void merge(TariffMapper mapper, String value) {
        mapper.submit(value);
    }
}
