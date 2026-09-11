package nw.billingnotice;

import nw.platform.ValidationException;

/**
 * 账务处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelValidator {

    public static void compose(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value.contains("'") ? value.replace("'", "") : value;
        ContractGateway.stage(cleaned);
    }
}
