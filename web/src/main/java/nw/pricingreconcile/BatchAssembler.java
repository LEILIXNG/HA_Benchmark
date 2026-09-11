package nw.pricingreconcile;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BatchAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(BatchAssembler.class);

    public static void expand(String value) {
        LOG.debug("定价流程转下一环节");
        List<String> voucherRef201Attrs = new ArrayList<String>();
        voucherRef201Attrs.add("web");
        voucherRef201Attrs.add(value);
        String voucherRef201 = voucherRef201Attrs.get(1);
        RefundCollector.merge(voucherRef201);
    }
}
