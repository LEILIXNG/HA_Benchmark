package nw.pricingrollup;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ChannelGateway {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelGateway.class);

    public static void route(String value) {
        LOG.debug("开始整理定价字段");
        try (SqlSession session = MapperSessions.open(ChannelMapper.class)) {
            refine(session.getMapper(ChannelMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void refine(ChannelMapper mapper, String value) {
        mapper.translate(value);
    }
}
