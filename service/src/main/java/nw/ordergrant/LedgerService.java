package nw.ordergrant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class LedgerService {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerService.class);
    private static String cachedCatalog;

    public static void assemble(String value) {
        LOG.trace("进入订单处理环节");
        String voucherRef301 = String.valueOf(value);
        cachedCatalog = voucherRef301;
        resolve();
    }

    private static void resolve() {
        String paymentTag302 = cachedCatalog;
        String refundCode303 = String.valueOf(paymentTag302);
        CatalogFetcher.collect(refundCode303);
    }
}
