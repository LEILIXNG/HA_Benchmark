package nw.catalogsplit;

/**
 * 商品处理策略的入口。
 */
public final class ShipmentRuleSelector {

    public static void forward(String value) {
        ShipmentRule handler = expand();
        handler.handle(value);
    }

    private static ShipmentRule expand() {
        return new ShipmentRuleStandard();
    }
}
