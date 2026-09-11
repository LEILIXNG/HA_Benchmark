package nw.fulfilexport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("fulfilexportContractCollector")
public class ContractCollector {
    private static final Logger LOG = LoggerFactory.getLogger(ContractCollector.class);
    private final InvoiceAdapter invoiceAdapter;

    public ContractCollector(InvoiceAdapter invoiceAdapter) {
        this.invoiceAdapter = invoiceAdapter;
    }

    public void expand(String value) {
        LOG.trace("进入履约处理环节");
        final String receiptKey101 = value;
        String accountRef102 = String.format("ref_%s", receiptKey101);
        this.invoiceAdapter.translate(accountRef102);
    }
}
