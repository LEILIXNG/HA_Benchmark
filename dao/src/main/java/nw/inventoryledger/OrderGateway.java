package nw.inventoryledger;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class OrderGateway {
    private static final Logger LOG = LoggerFactory.getLogger(OrderGateway.class);

    public static void compose(String value) {
        LOG.debug("开始整理库存字段");
        try (SqlSession session = MapperSessions.open(OrderMapper.class)) {
            stage(session.getMapper(OrderMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void stage(OrderMapper mapper, String value) {
        mapper.attach(value);
    }
}
