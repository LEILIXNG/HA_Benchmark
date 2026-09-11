package nw.shippingsubmit;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BundleNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(BundleNormalizer.class);

    public static void attach(String value) {
        LOG.trace("进入发运处理环节");
        List<String> receiptKey501Attrs = new ArrayList<String>();
        receiptKey501Attrs.add("web");
        receiptKey501Attrs.add(value);
        String receiptKey501 = receiptKey501Attrs.get(1);
        String accountRef502 = String.format("ref_%s", receiptKey501);
        QuoteEnricher.publish(accountRef502);
    }
}
