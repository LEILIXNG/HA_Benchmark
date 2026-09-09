package com.northwind.inventorysettle.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 库存主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("inventorysettleManifestTranslator")
public class ManifestTranslator {

    public void normalize(String value) {
        Map<String, String> manifestKey401Attrs = new HashMap<String, String>();
        manifestKey401Attrs.put("channel", "web");
        manifestKey401Attrs.put("detail", value);
        String manifestKey401 = manifestKey401Attrs.get("detail");
        ContractValidator.forward(manifestKey401);
    }
}
