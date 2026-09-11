package nw.customersplit;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class OrderGateway {
    private static final Logger LOG = LoggerFactory.getLogger(OrderGateway.class);

    public static void reconcile(String value) {
        LOG.debug("客户流程转下一环节");
        try (SqlSession session = MapperSessions.open(OrderMapper.class)) {
            collect(session.getMapper(OrderMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void collect(OrderMapper mapper, String value) {
        mapper.translate(value);
    }
}
