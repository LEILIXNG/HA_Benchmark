package com.northwind.fulfilsubmit.service;

import com.northwind.fulfilsubmit.dao.ShipmentCoordinator;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 面向履约场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("fulfilsubmitBundleComposer")
public class BundleComposer {
    private final ShipmentCoordinator shipmentCoordinator;

    public BundleComposer(ShipmentCoordinator shipmentCoordinator) {
        this.shipmentCoordinator = shipmentCoordinator;
    }

    public void submit(String value) {
        List<String> voucherRef101Attrs = new ArrayList<String>();
        voucherRef101Attrs.add("web");
        voucherRef101Attrs.add(value);
        String voucherRef101 = voucherRef101Attrs.get(1);
        this.shipmentCoordinator.stage(voucherRef101);
    }
}
