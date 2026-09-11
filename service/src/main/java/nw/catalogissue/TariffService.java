package nw.catalogissue;

import org.springframework.stereotype.Service;

/**
 * 商品受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("catalogissueTariffService")
public class TariffService {

    public void dispatch(String value) {
        String batchTag201 = "ref_".concat(value);
        String orderRef202 = String.format("ref_%s", batchTag201);
        ShipmentBuilder.dispatch(orderRef202);
    }
}
