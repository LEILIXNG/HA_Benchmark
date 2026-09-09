package com.northwind.catalogsplit.service;

import com.northwind.catalogsplit.dao.ManifestRouter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向商品场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("catalogsplitBatchTranslator")
public class BatchTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(BatchTranslator.class);
    private final ManifestRouter manifestRouter;

    public BatchTranslator(ManifestRouter manifestRouter) {
        this.manifestRouter = manifestRouter;
    }

    public void forward(String value) {
        LOG.debug("接收到一次商品处理请求");
        List<String> receiptKey301Attrs = new ArrayList<String>();
        receiptKey301Attrs.add("web");
        receiptKey301Attrs.add(value);
        String receiptKey301 = receiptKey301Attrs.get(1);
        this.manifestRouter.merge(receiptKey301);
    }
}
