package nw.orderrelease;

/** 订单处理策略。按渠道挑一个实现。 */
public interface TariffRule {

    void handle(String value);
}
