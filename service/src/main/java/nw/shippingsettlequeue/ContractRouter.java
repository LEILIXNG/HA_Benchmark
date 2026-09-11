package nw.shippingsettlequeue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 发运主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("shippingsettlequeueContractRouter")
public class ContractRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractRouter.class);

    public void forward(String value) {
        LOG.debug("发运流程转下一环节");
        String invoiceKey101 = value;
        ChannelEnricher.reconcile(invoiceKey101);
    }
}
