package nw.fulfilposting;

/**
 * 履约主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class BundleRegistry {

    public static void dispatch(String value) {
        String accountRef301 = "ref_" + value;
        BatchResolver.expand(accountRef301);
    }
}
