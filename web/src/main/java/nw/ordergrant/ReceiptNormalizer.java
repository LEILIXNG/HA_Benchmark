package nw.ordergrant;

import org.springframework.stereotype.Component;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("ordergrantReceiptNormalizer")
public class ReceiptNormalizer {
    private static String cachedCatalog;
    private final AccountService accountService;

    public ReceiptNormalizer(AccountService accountService) {
        this.accountService = accountService;
    }

    public void compose(String value) {
        final String voucherRef1 = value;
        cachedCatalog = voucherRef1;
        translate();
    }

    private void translate() {
        String paymentTag2 = cachedCatalog;
        final String refundCode3 = paymentTag2;
        String shipmentCode4 = String.valueOf(refundCode3);
        this.accountService.submit(shipmentCode4);
    }
}
