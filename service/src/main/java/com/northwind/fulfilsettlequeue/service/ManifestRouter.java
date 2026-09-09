package com.northwind.fulfilsettlequeue.service;

import com.northwind.fulfilsettlequeue.dao.SessionTranslator;
import org.springframework.stereotype.Service;

/**
 * 履约主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("fulfilsettlequeueManifestRouter")
public class ManifestRouter {
    private final SessionTranslator sessionTranslator;

    public ManifestRouter(SessionTranslator sessionTranslator) {
        this.sessionTranslator = sessionTranslator;
    }

    public void forward(String value) {
        String orderRef101 = String.valueOf(value);
        String quoteRef102 = orderRef101;
        this.sessionTranslator.route(quoteRef102);
    }
}
