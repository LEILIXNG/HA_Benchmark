package nw.vendorsync;

import org.springframework.stereotype.Service;

/**
 * 供应商受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("vendorsyncShipmentService")
public class ShipmentService {
    private static String cachedBatch;

    public void register(String value) {
        String manifestKey101 = "ref_" + value;
        cachedBatch = manifestKey101;
        merge();
    }

    private void merge() {
        String invoiceKey102 = cachedBatch;
        String batchTag103 = "ref_" + invoiceKey102;
        RefundService.dispatch(batchTag103);
    }
}
