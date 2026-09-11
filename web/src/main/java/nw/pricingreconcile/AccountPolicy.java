package nw.pricingreconcile;

/** 定价处理策略。按渠道挑一个实现。 */
public interface AccountPolicy {

    void handle(String value);
}
