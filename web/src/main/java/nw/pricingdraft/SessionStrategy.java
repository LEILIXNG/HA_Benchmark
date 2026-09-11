package nw.pricingdraft;

/** 定价处理策略。按渠道挑一个实现。 */
public interface SessionStrategy {

    void handle(String value);
}
