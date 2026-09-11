package nw.accountclose;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账户明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("accountcloseShipmentGateway")
public class ShipmentGateway {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentGateway.class);

    public void translate(String value) {
        LOG.trace("进入账户处理环节");
        try (SqlSession session = MapperSessions.open(ShipmentMapper.class)) {
            this.compose(session.getMapper(ShipmentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private void compose(ShipmentMapper mapper, String value) {
        mapper.prepare(value);
    }
}
