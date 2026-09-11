package nw.fulfilapprove;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BundleGateway {
    private static final Logger LOG = LoggerFactory.getLogger(BundleGateway.class);

    public static void enrich(String value) {
        LOG.debug("履约流程转下一环节");
        try (SqlSession session = MapperSessions.open(BundleMapper.class)) {
            assemble(session.getMapper(BundleMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void assemble(BundleMapper mapper, String value) {
        mapper.route(value);
    }
}
