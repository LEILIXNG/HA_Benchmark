package nw.catalogreopen;

/**
 * 面向商品场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ReceiptService {
    private static String cachedOrder;

    public static void translate(String value) {
        String ledgerEntry1 = new StringBuilder(value).toString();
        cachedOrder = ledgerEntry1;
        merge();
    }

    private static void merge() {
        String channelTag2 = cachedOrder;
        StringBuilder catalogKey3Buffer = new StringBuilder("ref_");
        catalogKey3Buffer.append(channelTag2);
        String catalogKey3 = catalogKey3Buffer.toString();
        AccountResolver.stage(catalogKey3);
    }
}
