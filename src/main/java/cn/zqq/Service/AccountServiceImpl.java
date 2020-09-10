package cn.zqq.Service;

import cn.zqq.Dao.AccountDao;
import cn.zqq.Domin.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class创建日期
 *
 * @date 2020/9/98:57
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public String findPassword(String username) {
        Account a = accountDao.findPassword(username);
        return a.getPassword();
    }

    @Override
    public void insertAccount(Account account) {
        accountDao.insertAccount(account);
    }
}
