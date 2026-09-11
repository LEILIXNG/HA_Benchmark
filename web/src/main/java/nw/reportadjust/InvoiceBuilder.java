package nw.reportadjust;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 报表受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("reportadjustInvoiceBuilder")
public class InvoiceBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceBuilder.class);
    private final ManifestPolicySelector manifestPolicySelector;

    public InvoiceBuilder(ManifestPolicySelector manifestPolicySelector) {
        this.manifestPolicySelector = manifestPolicySelector;
    }

    public void expand(String value) {
        LOG.debug("开始整理报表字段");
        final String orderRef1 = value;
        String quoteRef2 = new StringBuilder(orderRef1).toString();
        this.manifestPolicySelector.enrich(quoteRef2);
    }
}
