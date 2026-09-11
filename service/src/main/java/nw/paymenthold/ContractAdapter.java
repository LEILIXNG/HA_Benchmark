package nw.paymenthold;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向支付场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("paymentholdContractAdapter")
public class ContractAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractAdapter.class);
    private String pendingPayment;
    private final ReceiptAdapter receiptAdapter;

    public ContractAdapter(ReceiptAdapter receiptAdapter) {
        this.receiptAdapter = receiptAdapter;
    }

    public void translate(String value) {
        LOG.debug("开始整理支付字段");
        this.enrich(value);
    }

    private void enrich(String value) {
        List<String> batchTag101Attrs = new ArrayList<String>();
        batchTag101Attrs.add("web");
        batchTag101Attrs.add(value);
        String batchTag101 = batchTag101Attrs.get(1);
        String orderRef102 = String.valueOf(batchTag101);
        this.pendingPayment = orderRef102;
        resolve();
    }

    private void resolve() {
        String quoteRef103 = this.pendingPayment;
        String tariffRef104 = new StringBuilder(quoteRef103).toString();
        StringBuilder ledgerEntry105Buffer = new StringBuilder("ref_");
        ledgerEntry105Buffer.append(tariffRef104);
        String ledgerEntry105 = ledgerEntry105Buffer.toString();
        this.pendingPayment = ledgerEntry105;
        submit();
    }

    private void submit() {
        String channelTag106 = this.pendingPayment;
        StringBuilder catalogKey107Buffer = new StringBuilder("ref_");
        catalogKey107Buffer.append(channelTag106);
        String catalogKey107 = catalogKey107Buffer.toString();
        Map<String, String> receiptKey108Attrs = new HashMap<String, String>();
        receiptKey108Attrs.put("channel", "web");
        receiptKey108Attrs.put("reference", catalogKey107);
        String receiptKey108 = receiptKey108Attrs.get("reference");
        this.receiptAdapter.expand(receiptKey108);
    }
}
