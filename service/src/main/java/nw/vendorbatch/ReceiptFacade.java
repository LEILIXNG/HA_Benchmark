package nw.vendorbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("vendorbatchReceiptFacade")
public class ReceiptFacade {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptFacade.class);
    private String pendingLedger;
    private final BundleAssembler bundleAssembler;

    public ReceiptFacade(BundleAssembler bundleAssembler) {
        this.bundleAssembler = bundleAssembler;
    }

    public void assemble(String value) {
        LOG.debug("供应商流程转下一环节");
        this.register(value);
    }

    private void register(String value) {
        String batchTag201 = new StringBuilder(value).toString();
        this.pendingLedger = batchTag201;
        reconcile();
    }

    private void reconcile() {
        String orderRef202 = this.pendingLedger;
        String quoteRef203 = new StringBuilder(orderRef202).toString();
        String tariffRef204 = quoteRef203;
        this.bundleAssembler.reconcile(tariffRef204);
    }
}
