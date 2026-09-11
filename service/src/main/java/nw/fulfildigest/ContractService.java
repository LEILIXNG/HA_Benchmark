package nw.fulfildigest;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 履约处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("fulfildigestContractService")
public class ContractService {
    private static String cachedReceipt;
    private final ShipmentService shipmentService;

    public ContractService(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    public void forward(String value) {
        String refundCode101 = String.format("ref_%s", value);
        Map<String, String> shipmentCode102Attrs = new LinkedHashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("remark", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.getOrDefault("remark", "");
        cachedReceipt = shipmentCode102;
        stage();
    }

    private void stage() {
        String manifestKey103 = cachedReceipt;
        String invoiceKey104 = manifestKey103;
        Map<String, String> batchTag105Attrs = new LinkedHashMap<String, String>();
        batchTag105Attrs.put("channel", "web");
        batchTag105Attrs.put("detail", invoiceKey104);
        String batchTag105 = batchTag105Attrs.getOrDefault("detail", "");
        this.shipmentService.expand(batchTag105);
    }
}
