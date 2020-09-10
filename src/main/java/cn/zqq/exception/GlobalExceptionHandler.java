package cn.zqq.exception;

import org.springframework.beans.NotReadablePropertyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * class创建日期
 *
 * @date 2020/9/88:41
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception e ){
        ModelAndView mv = new ModelAndView();
        try {
            FileOutputStream fos=new FileOutputStream("D:\\SSO_Error.log",true);
            PrintStream ps=new PrintStream(fos);
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time=sdf.format(date)+"---------";
            System.out.println(time);
            ps.println();
            ps.print(time);

            //错误信息打印
            e.printStackTrace(ps);
            if (e instanceof NotReadablePropertyException)
                mv.setViewName("error/Invalidate");
            else mv.setViewName("error/exception");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mv;
    }
}
