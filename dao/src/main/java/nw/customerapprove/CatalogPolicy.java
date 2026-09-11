package nw.customerapprove;

import nw.platform.ValidationException;

/**
 * 客户受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class CatalogPolicy {

    public static void expand(String value) {
        // 去掉相对路径写法，统一按根目录拼
        String cleaned = value.contains("../") ? value.replace("../", "") : value;
        OrderLoader.submit(cleaned);
    }
}
