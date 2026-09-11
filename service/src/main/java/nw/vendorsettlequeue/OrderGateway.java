package nw.vendorsettlequeue;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;

/**
 * 供应商明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class OrderGateway {

    public static void register(String value) {
        try (SqlSession session = MapperSessions.open(OrderMapper.class)) {
            attach(session.getMapper(OrderMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void attach(OrderMapper mapper, String value) {
        mapper.collect(value);
    }
}
