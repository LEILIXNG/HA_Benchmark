package nw.orderissue;

/** 订单处理策略。按渠道挑一个实现。 */
public interface ChannelRule {

    void handle(String value);
}
