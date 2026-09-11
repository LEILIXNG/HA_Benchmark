package nw.shippingledger;

/** 发运处理策略。按渠道挑一个实现。 */
public interface ShipmentRule {

    void handle(String value);
}
