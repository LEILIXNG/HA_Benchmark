package nw.billingbatch;

import org.springframework.stereotype.Component;

/**
 * 账务主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("billingbatchReceiptService")
public class ReceiptService {
    private static String cachedPayment;
    private final ContractAdapter contractAdapter;

    public ReceiptService(ContractAdapter contractAdapter) {
        this.contractAdapter = contractAdapter;
    }

    public void submit(String value) {
        String receiptKey1 = String.valueOf(value);
        cachedPayment = receiptKey1;
        route();
    }

    private void route() {
        String accountRef2 = cachedPayment;
        StringBuilder voucherRef3Buffer = new StringBuilder("ref_");
        voucherRef3Buffer.append(accountRef2);
        String voucherRef3 = voucherRef3Buffer.toString();
        this.contractAdapter.translate(voucherRef3);
    }
}
