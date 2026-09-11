package nw.reportimport;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 报表明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("reportimportReceiptCoordinator")
public class ReceiptCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptCoordinator.class);
    private final InvoiceTranslator invoiceTranslator;

    public ReceiptCoordinator(InvoiceTranslator invoiceTranslator) {
        this.invoiceTranslator = invoiceTranslator;
    }

    public void collect(String value) {
        LOG.trace("进入报表处理环节");
        String ledgerEntry101 = value;
        List<String> channelTag102Attrs = new ArrayList<String>();
        channelTag102Attrs.add("web");
        channelTag102Attrs.add(ledgerEntry101);
        String channelTag102 = channelTag102Attrs.get(1);
        this.invoiceTranslator.resolve(channelTag102);
    }
}
