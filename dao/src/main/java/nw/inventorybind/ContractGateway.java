package nw.inventorybind;

import nw.platform.MapperSessions;
import nw.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ContractGateway {
    private static final Logger LOG = LoggerFactory.getLogger(ContractGateway.class);

    public static void route(String value) {
        LOG.trace("进入库存处理环节");
        try (SqlSession session = MapperSessions.open(ContractMapper.class)) {
            forward(session.getMapper(ContractMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private static void forward(ContractMapper mapper, String value) {
        mapper.forward(value);
    }
}
