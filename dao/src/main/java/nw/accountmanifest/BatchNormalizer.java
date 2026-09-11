package nw.accountmanifest;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class BatchNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(BatchNormalizer.class);

    public static void compose(String value) {
        LOG.trace("进入账户处理环节");
        List<String> orderRef301Attrs = new ArrayList<String>();
        orderRef301Attrs.add("web");
        orderRef301Attrs.add(value);
        String orderRef301 = orderRef301Attrs.get(1);
        QuoteGuard.compose(orderRef301);
    }
}
