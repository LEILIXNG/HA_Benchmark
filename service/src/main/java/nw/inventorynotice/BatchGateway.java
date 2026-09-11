package nw.inventorynotice;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BatchGateway {
    private static final Logger LOG = LoggerFactory.getLogger(BatchGateway.class);

    public static void merge(String value) {
        LOG.debug("库存流程转下一环节");
        try (SqlSession session = MapperSessions.open(BatchMapper.class)) {
            prepare(session.getMapper(BatchMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void prepare(BatchMapper mapper, String value) {
        mapper.refine(value);
    }
}
