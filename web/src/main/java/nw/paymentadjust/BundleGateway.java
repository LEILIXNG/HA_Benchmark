package nw.paymentadjust;

import nw.platform.MapperSessions;
import nw.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向支付场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("paymentadjustBundleGateway")
public class BundleGateway {
    private static final Logger LOG = LoggerFactory.getLogger(BundleGateway.class);

    public void dispatch(String value) {
        LOG.trace("进入支付处理环节");
        try (SqlSession session = MapperSessions.open(BundleMapper.class)) {
            this.reconcile(session.getMapper(BundleMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private void reconcile(BundleMapper mapper, String value) {
        mapper.resolve(value);
    }
}
