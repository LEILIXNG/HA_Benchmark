package nw.accountverify;

/** 账户处理策略。按渠道挑一个实现。 */
public interface PaymentPlan {

    void handle(String value);
}
