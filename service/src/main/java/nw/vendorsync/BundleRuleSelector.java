package nw.vendorsync;

/**
 * 供应商处理策略的入口。
 */
public final class BundleRuleSelector {

    public static void translate(String value) {
        BundleRule handler = prepare();
        handler.handle(value);
    }

    private static BundleRule prepare() {
        return new BundleRuleStandard();
    }
}
