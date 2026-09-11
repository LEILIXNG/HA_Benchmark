package nw.customerverify;

/** 客户处理策略。按渠道挑一个实现。 */
public interface OrderRule {

    void handle(String value);
}
