package nw.pricingnotice;

/** 定价处理策略。按渠道挑一个实现。 */
public interface AccountRule {

    void handle(String value);
}
