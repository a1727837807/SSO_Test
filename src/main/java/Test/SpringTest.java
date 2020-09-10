package Test;

import cn.zqq.Service.AccountService;
import cn.zqq.Service.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * class创建日期
 *
 * @date 2020/9/99:26
 */
public class SpringTest {
    @Test
    public void run(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:ApplicationContext.Xml");
        AccountService accountServiceImpl = (AccountServiceImpl)applicationContext.getBean("accountServiceImpl");
        String zqq = accountServiceImpl.findPassword("zqq");
        System.out.println(zqq);
    }
}
