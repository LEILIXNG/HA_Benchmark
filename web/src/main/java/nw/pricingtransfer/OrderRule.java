package nw.pricingtransfer;

/** 定价处理策略。按渠道挑一个实现。 */
public interface OrderRule {

    void handle(String value);
}
