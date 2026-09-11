package nw.cataloggrant;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class QuoteComposer {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteComposer.class);

    public static void route(String value) {
        LOG.trace("进入商品处理环节");
        List<String> manifestKey401Attrs = new ArrayList<String>();
        manifestKey401Attrs.add("web");
        manifestKey401Attrs.add(value);
        String manifestKey401 = manifestKey401Attrs.get(1);
        final String invoiceKey402 = manifestKey401;
        ManifestExecutor.collect(invoiceKey402);
    }
}
