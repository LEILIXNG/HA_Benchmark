package nw.billingnotice;

import nw.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;

/**
 * 面向账务场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ContractGateway {

    public static void stage(String value) {
        try (SqlSession session = MapperSessions.open(ContractMapper.class)) {
            submit(session.getMapper(ContractMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private static void submit(ContractMapper mapper, String value) {
        mapper.translate(value);
    }
}
