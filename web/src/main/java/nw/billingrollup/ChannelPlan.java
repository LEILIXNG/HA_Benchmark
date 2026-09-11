package nw.billingrollup;

/** 账务处理策略。按渠道挑一个实现。 */
public interface ChannelPlan {

    void handle(String value);
}
