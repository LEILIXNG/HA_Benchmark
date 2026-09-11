package nw.vendordigest;

/** 供应商处理策略。按渠道挑一个实现。 */
public interface ManifestPolicy {

    void handle(String value);
}
