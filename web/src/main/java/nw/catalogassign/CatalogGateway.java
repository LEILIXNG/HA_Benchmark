package nw.catalogassign;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class CatalogGateway {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogGateway.class);

    public static void submit(String value) {
        LOG.debug("开始整理商品字段");
        try (SqlSession session = MapperSessions.open(CatalogMapper.class)) {
            expand(session.getMapper(CatalogMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void expand(CatalogMapper mapper, String value) {
        mapper.register(value);
    }
}
