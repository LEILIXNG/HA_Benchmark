package nw.vendorsync;

/** 供应商处理策略。按渠道挑一个实现。 */
public interface BundleRule {

    void handle(String value);
}
