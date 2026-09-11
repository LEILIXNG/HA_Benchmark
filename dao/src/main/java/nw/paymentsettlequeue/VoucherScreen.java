package nw.paymentsettlequeue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class VoucherScreen {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherScreen.class);

    public static void expand(String value) {
        // 历史脚本里带分号会切断参数，先删掉
        String cleaned = value.replace(";", "");
        SessionExecutor.publish(cleaned);
    }
}
