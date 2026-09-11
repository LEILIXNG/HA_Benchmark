package nw.orderrollup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("orderrollupAccountService")
public class AccountService {
    private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);

    public void forward(String value) {
        LOG.trace("进入订单处理环节");
        final String tariffRef201 = value;
        InvoiceAssembler.dispatch(tariffRef201);
    }
}
