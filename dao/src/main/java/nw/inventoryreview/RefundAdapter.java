package nw.inventoryreview;

/**
 * 库存受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class RefundAdapter {

    public static void register(String value) {
        String ledgerEntry301 = String.valueOf(value);
        String channelTag302 = ledgerEntry301;
        ManifestStrategySelector.refine(channelTag302);
    }
}
