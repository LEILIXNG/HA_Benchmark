package nw.inventorydispatch;

import java.util.ArrayList;
import java.util.List;

/**
 * 库存主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class InvoiceAssembler {

    public static void register(String value) {
        List<String> shipmentCode301Attrs = new ArrayList<String>();
        shipmentCode301Attrs.add("web");
        shipmentCode301Attrs.add(value);
        String shipmentCode301 = shipmentCode301Attrs.get(1);
        String manifestKey302 = String.valueOf(shipmentCode301);
        ChannelRegistry.refine(manifestKey302);
    }
}
