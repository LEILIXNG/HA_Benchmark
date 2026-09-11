package nw.catalogrenewal;

/** 商品处理策略。按渠道挑一个实现。 */
public interface PaymentRule {

    void handle(String value);
}
