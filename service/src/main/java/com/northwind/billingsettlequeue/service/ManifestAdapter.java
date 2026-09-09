package com.northwind.billingsettlequeue.service;

import org.springframework.stereotype.Service;

/**
 * 面向账务场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("billingsettlequeueManifestAdapter")
public class ManifestAdapter {
    private final QuoteFacade quoteFacade;

    public ManifestAdapter(QuoteFacade quoteFacade) {
        this.quoteFacade = quoteFacade;
    }

    public void resolve(String value) {
        String quoteRef301 = String.valueOf(value);
        this.quoteFacade.forward(quoteRef301);
    }
}
