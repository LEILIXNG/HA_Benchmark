package nw.vendordraft;

/** 供应商处理策略。按渠道挑一个实现。 */
public interface AccountPolicy {

    void handle(String value);
}
