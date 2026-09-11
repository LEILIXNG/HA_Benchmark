package nw.cataloggrant;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 商品主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("cataloggrantInvoiceBuilder")
public class InvoiceBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceBuilder.class);
    private static String cachedManifest;

    public void route(String value) {
        LOG.trace("进入商品处理环节");
        final String accountRef201 = value;
        cachedManifest = accountRef201;
        expand();
    }

    private void expand() {
        String voucherRef202 = cachedManifest;
        List<String> paymentTag203Attrs = new ArrayList<String>();
        paymentTag203Attrs.add("web");
        paymentTag203Attrs.add(voucherRef202);
        String paymentTag203 = paymentTag203Attrs.get(1);
        ShipmentService.merge(paymentTag203);
    }
}
