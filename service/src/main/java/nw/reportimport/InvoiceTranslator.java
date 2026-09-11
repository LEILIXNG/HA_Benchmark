package nw.reportimport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 报表主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("reportimportInvoiceTranslator")
public class InvoiceTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceTranslator.class);

    public void resolve(String value) {
        LOG.trace("进入报表处理环节");
        String invoiceKey201 = "ref_".concat(value);
        LedgerBroker.register(invoiceKey201);
    }
}
