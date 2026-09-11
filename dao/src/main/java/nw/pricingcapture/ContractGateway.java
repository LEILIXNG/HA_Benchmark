package nw.pricingcapture;

import nw.platform.MapperSessions;
import nw.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * 定价主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("pricingcaptureContractGateway")
public class ContractGateway {

    public void publish(String value) {
        try (SqlSession session = MapperSessions.open(ContractMapper.class)) {
            this.forward(session.getMapper(ContractMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private void forward(ContractMapper mapper, String value) {
        mapper.collect(value);
    }
}
