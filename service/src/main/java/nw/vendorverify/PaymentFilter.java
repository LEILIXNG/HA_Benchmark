package nw.vendorverify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class PaymentFilter {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentFilter.class);

    public static void prepare(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value.contains("'") ? value.replace("'", "") : value;
        ChannelGateway.resolve(cleaned);
    }
}
