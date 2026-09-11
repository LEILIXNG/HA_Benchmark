package nw.fulfilrevise;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/**
 * 履约受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("fulfilreviseShipmentGateway")
public class ShipmentGateway {

    public void dispatch(String value) {
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            this.attach(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private void attach(ShipmentMapper mapper, String value) {
        mapper.stage(value);
    }
}
