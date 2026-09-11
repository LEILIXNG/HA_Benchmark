package nw.fulfilrelease;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class PaymentGateway {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentGateway.class);

    public static void submit(String value) {
        LOG.debug("履约流程转下一环节");
        try (SqlSession session = MapperSessions.open(PaymentMapper.class)) {
            route(session.getMapper(PaymentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void route(PaymentMapper mapper, String value) {
        mapper.expand(value);
    }
}
