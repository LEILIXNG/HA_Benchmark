package nw.billingbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账务主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("billingbatchSessionBuilder")
public class SessionBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(SessionBuilder.class);

    public void resolve(String value) {
        LOG.debug("开始整理账务字段");
        final String shipmentCode201 = value;
        PaymentEvaluator.collect(shipmentCode201);
    }
}
