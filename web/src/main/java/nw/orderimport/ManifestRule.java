package nw.orderimport;

/** 订单处理策略。按渠道挑一个实现。 */
public interface ManifestRule {

    void handle(String value);
}
