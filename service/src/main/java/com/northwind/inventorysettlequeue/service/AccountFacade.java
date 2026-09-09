package com.northwind.inventorysettlequeue.service;

import com.northwind.inventorysettlequeue.dao.BatchRegistry;
import org.springframework.stereotype.Service;

/**
 * 面向库存场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("inventorysettlequeueAccountFacade")
public class AccountFacade {
    private final BatchRegistry batchRegistry;

    public AccountFacade(BatchRegistry batchRegistry) {
        this.batchRegistry = batchRegistry;
    }

    public void prepare(String value) {
        String refundCode301 = String.format("ref:%s;", value);
        this.batchRegistry.reconcile(refundCode301);
    }
}
