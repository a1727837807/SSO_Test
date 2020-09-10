package cn.zqq.Service;

import cn.zqq.Domin.Account;

/**
 * class创建日期
 *
 * @date 2020/9/98:57
 */
public interface AccountService {
    String findPassword(String username);

    void insertAccount(Account account);
}
