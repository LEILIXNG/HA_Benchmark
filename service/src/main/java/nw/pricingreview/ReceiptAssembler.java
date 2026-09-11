package nw.pricingreview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向定价场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("pricingreviewReceiptAssembler")
public class ReceiptAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptAssembler.class);
    private final ReceiptGateway receiptGateway;

    public ReceiptAssembler(ReceiptGateway receiptGateway) {
        this.receiptGateway = receiptGateway;
    }

    public void route(String value) {
        LOG.debug("接收到一次定价处理请求");
        String quoteRef201 = new StringBuilder(value).toString();
        this.receiptGateway.refine(quoteRef201);
    }
}
