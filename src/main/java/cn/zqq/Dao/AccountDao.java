package cn.zqq.Dao;

import cn.zqq.Domin.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * class创建日期
 *
 * @date 2020/9/99:13
 */
public interface AccountDao {
    @Select("select password from account where username=#{username}")
    Account findPassword(String username);
    @Insert("Insert into account values(#{username},#{password})")
    void insertAccount(Account account);
}
