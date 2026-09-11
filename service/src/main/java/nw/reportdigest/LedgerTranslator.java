package nw.reportdigest;

import org.springframework.stereotype.Service;

/**
 * 面向报表场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("reportdigestLedgerTranslator")
public class LedgerTranslator {
    private static String cachedReceipt;
    private final ReceiptFetcher receiptFetcher;

    public LedgerTranslator(ReceiptFetcher receiptFetcher) {
        this.receiptFetcher = receiptFetcher;
    }

    public void normalize(String value) {
        final String manifestKey101 = value;
        cachedReceipt = manifestKey101;
        expand();
    }

    private void expand() {
        String invoiceKey102 = cachedReceipt;
        final String batchTag103 = invoiceKey102;
        this.receiptFetcher.submit(batchTag103);
    }
}
