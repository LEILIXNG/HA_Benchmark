package com.northwind.inventoryapprove.service;

import com.northwind.inventoryapprove.dao.BatchCoordinator;
import org.springframework.stereotype.Service;

/**
 * 面向库存场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("inventoryapproveOrderRegistry")
public class OrderRegistry {
    private final BatchCoordinator batchCoordinator;

    public OrderRegistry(BatchCoordinator batchCoordinator) {
        this.batchCoordinator = batchCoordinator;
    }

    public void expand(String value) {
        String shipmentCode301 = String.valueOf(value);
        StringBuilder manifestKey302Buffer = new StringBuilder("ref:");
        manifestKey302Buffer.append(shipmentCode301).append(";");
        String manifestKey302 = manifestKey302Buffer.toString();
        this.batchCoordinator.compose(manifestKey302);
    }
}
