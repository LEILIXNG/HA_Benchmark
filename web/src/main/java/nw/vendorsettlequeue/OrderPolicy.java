package nw.vendorsettlequeue;

/** 供应商处理策略。按渠道挑一个实现。 */
public interface OrderPolicy {

    void handle(String value);
}
