package nw.inventoryarchive;

import org.springframework.stereotype.Repository;

/**
 * 面向库存场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("inventoryarchiveTariffAdapter")
public class TariffAdapter {
    private static String cachedCatalog;
    private final CatalogLoader catalogLoader;

    public TariffAdapter(CatalogLoader catalogLoader) {
        this.catalogLoader = catalogLoader;
    }

    public void dispatch(String value) {
        StringBuilder channelTag201Buffer = new StringBuilder("ref_");
        channelTag201Buffer.append(value);
        String channelTag201 = channelTag201Buffer.toString();
        String catalogKey202 = new StringBuilder(channelTag201).toString();
        cachedCatalog = catalogKey202;
        collect();
    }

    private void collect() {
        String receiptKey203 = cachedCatalog;
        String accountRef204 = String.valueOf(receiptKey203);
        String voucherRef205 = "ref_".concat(accountRef204);
        this.catalogLoader.prepare(voucherRef205);
    }
}
