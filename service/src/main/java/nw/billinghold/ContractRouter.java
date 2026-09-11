package nw.billinghold;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("billingholdContractRouter")
public class ContractRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractRouter.class);
    private final ReceiptExecutor receiptExecutor;

    public ContractRouter(ReceiptExecutor receiptExecutor) {
        this.receiptExecutor = receiptExecutor;
    }

    public void attach(String value) {
        LOG.debug("开始整理账务字段");
        String tariffRef501 = "ref_".concat(value);
        List<String> ledgerEntry502Attrs = new ArrayList<String>();
        ledgerEntry502Attrs.add("web");
        ledgerEntry502Attrs.add(tariffRef501);
        String ledgerEntry502 = ledgerEntry502Attrs.get(1);
        this.receiptExecutor.forward(ledgerEntry502);
    }
}
