package nw.pricingassign;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;

/**
 * 定价受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ShipmentGateway {

    public static void expand(String value) {
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            refine(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void refine(ShipmentMapper mapper, String value) {
        mapper.refine(value);
    }
}
