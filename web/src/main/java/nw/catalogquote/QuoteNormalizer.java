package nw.catalogquote;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("catalogquoteQuoteNormalizer")
public class QuoteNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteNormalizer.class);
    private static String cachedTariff;
    private final VoucherAssembler voucherAssembler;

    public QuoteNormalizer(VoucherAssembler voucherAssembler) {
        this.voucherAssembler = voucherAssembler;
    }

    public void register(String value) {
        LOG.debug("开始整理商品字段");
        StringBuilder accountRef1Buffer = new StringBuilder("ref_");
        accountRef1Buffer.append(value);
        String accountRef1 = accountRef1Buffer.toString();
        String voucherRef2 = "ref_" + accountRef1;
        cachedTariff = voucherRef2;
        refine();
    }

    private void refine() {
        String paymentTag3 = cachedTariff;
        final String refundCode4 = paymentTag3;
        List<String> shipmentCode5Attrs = new ArrayList<String>();
        shipmentCode5Attrs.add("web");
        shipmentCode5Attrs.add(refundCode4);
        String shipmentCode5 = shipmentCode5Attrs.get(1);
        this.voucherAssembler.expand(shipmentCode5);
    }
}
