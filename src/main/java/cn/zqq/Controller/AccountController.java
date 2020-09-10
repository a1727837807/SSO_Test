package cn.zqq.Controller;

import cn.zqq.Domin.Account;
import cn.zqq.Service.AccountService;
import cn.zqq.exception.AccountValidator;
import cn.zqq.exception.PhoneValidator;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import util.SMSUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * class创建日期
 *
 * @date 2020/9/98:54
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
   private  AccountService accountService;
    @RequestMapping(path = "/login.do",method= RequestMethod.POST,params ={ "username","password"},produces = "text/json;charset=UTF-8")
    @ResponseBody//此注释将返回值加入到HTTP响应体而不是作为视图名称
    public ResponseEntity validateAccount(@RequestParam("username") String username, @RequestParam("password")String password){
        String password1 = accountService.findPassword(username);
        System.out.println(password1);
            if (password.equals(password1)) {
                System.out.println("111");
                return new ResponseEntity("登录成功",HttpStatus.OK);
            }
        System.out.println("222");
            return new ResponseEntity("错误的账户/密码",HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(path = "/sendCheckNum.do",method=RequestMethod.POST,params = {"phone"})
    public String registerAccount(HttpServletRequest request,@RequestParam("phone")String phone) throws Exception {
        System.out.println(phone);
        if (phone.matches("^1[3456789]\\d{9}$")){
            int i = SMSUtil.SendCode(phone);
            System.out.println(i);
            if (i!=Integer.MIN_VALUE){
                HttpSession session = request.getSession();
                session.setAttribute("checkNum",i);
                session.setAttribute("phone",phone);
                return "redirect:validate.jsp";
            }
        }
        return "error";
    }
    @RequestMapping(path = "/validate.do",method=RequestMethod.POST,params = {"checkNum"})
    public String validateCheckNum(HttpServletRequest request,@RequestParam("checkNum")String checkNum){
        System.out.println(checkNum);
        HttpSession session = request.getSession();
        int checkNum1 = (Integer)session.getAttribute("checkNum");
        int checkNum2=Integer.parseInt(checkNum);
        System.out.println(checkNum1);
        if (checkNum1==checkNum2){
            return "redirect:insertAccount.jsp";
        }
        return "error1";
    }
    @RequestMapping(path = "/register.do",method=RequestMethod.POST,params = {"username","password"},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity insertAccount(@ModelAttribute Account account,BindingResult bindingResult){
        new AccountValidator().validate(account,bindingResult);
        if (!bindingResult.hasErrors()){
            accountService.insertAccount(account);
            return new ResponseEntity("创建成功！！",HttpStatus.OK);
        }
        return new ResponseEntity("用户名/密码 不符合规范",HttpStatus.BAD_REQUEST);
    }

}
