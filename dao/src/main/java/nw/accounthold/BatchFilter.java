package nw.accounthold;

import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BatchFilter {
    private static final Logger LOG = LoggerFactory.getLogger(BatchFilter.class);

    public static void resolve(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value;
        if (cleaned.indexOf("'") >= 0) {
            cleaned = cleaned.replace("'", "");
        }
        SessionRepository.compose(cleaned);
    }
}
