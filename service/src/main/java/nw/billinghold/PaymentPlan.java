package nw.billinghold;

/** 账务处理策略。按渠道挑一个实现。 */
public interface PaymentPlan {

    void handle(String value);
}
