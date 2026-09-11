package nw.customersplit;

import nw.platform.ValidationException;

/**
 * 客户主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class TariffValidator {

    public static void stage(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value;
        if (cleaned.indexOf("'") >= 0) {
            cleaned = cleaned.replace("'", "");
        }
        OrderGateway.reconcile(cleaned);
    }
}
