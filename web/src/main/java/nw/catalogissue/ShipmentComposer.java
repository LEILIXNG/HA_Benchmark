package nw.catalogissue;

import org.springframework.stereotype.Component;

/**
 * 商品明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("catalogissueShipmentComposer")
public class ShipmentComposer {
    private final TariffService tariffService;

    public ShipmentComposer(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    public void resolve(String value) {
        StringBuilder channelTag101Buffer = new StringBuilder("ref_");
        channelTag101Buffer.append(value);
        String channelTag101 = channelTag101Buffer.toString();
        this.tariffService.dispatch(channelTag101);
    }
}
