package nw.shippingreconcile;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向发运场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ContractNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ContractNormalizer.class);

    public static void attach(String value) {
        LOG.debug("开始整理发运字段");
        List<String> manifestKey501Attrs = new ArrayList<String>();
        manifestKey501Attrs.add("web");
        manifestKey501Attrs.add(value);
        String manifestKey501 = manifestKey501Attrs.get(1);
        List<String> invoiceKey502Attrs = new ArrayList<String>();
        invoiceKey502Attrs.add("web");
        invoiceKey502Attrs.add(manifestKey501);
        String invoiceKey502 = invoiceKey502Attrs.get(1);
        PaymentLoader.forward(invoiceKey502);
    }
}
