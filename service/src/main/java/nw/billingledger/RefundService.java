package nw.billingledger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("billingledgerRefundService")
public class RefundService {
    private static final Logger LOG = LoggerFactory.getLogger(RefundService.class);

    public void submit(String value) {
        LOG.debug("账务流程转下一环节");
        String shipmentCode101 = new StringBuilder(value).toString();
        final String manifestKey102 = shipmentCode101;
        AccountRepository.submit(manifestKey102);
    }
}
