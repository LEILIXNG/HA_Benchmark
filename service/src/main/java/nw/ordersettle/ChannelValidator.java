package nw.ordersettle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelValidator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelValidator.class);

    public static void assemble(String value) {
        // 模板里不允许出现类型前缀
        String cleaned = value;
        if (cleaned.indexOf("T(") >= 0) {
            cleaned = cleaned.replace("T(", "");
        }
        ShipmentEvaluator.forward(cleaned);
    }
}
