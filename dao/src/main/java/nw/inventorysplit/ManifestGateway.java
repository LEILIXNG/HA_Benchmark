package nw.inventorysplit;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ManifestGateway {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestGateway.class);

    public static void translate(String value) {
        LOG.debug("库存流程转下一环节");
        try (SqlSession session = MapperSessions.open(ManifestMapper.class)) {
            assemble(session.getMapper(ManifestMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void assemble(ManifestMapper mapper, String value) {
        mapper.dispatch(value);
    }
}
