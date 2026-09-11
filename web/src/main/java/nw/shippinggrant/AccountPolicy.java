package nw.shippinggrant;

/** 发运处理策略。按渠道挑一个实现。 */
public interface AccountPolicy {

    void handle(String value);
}
