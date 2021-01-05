package com.example.jwxt.controller.Impl;

import com.example.jwxt.controller.CheckController;
import com.example.jwxt.controller.IVerifyCodeGen;
import com.example.jwxt.entity.VerifyCode;
import com.example.jwxt.support.utils.ImageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class CheckControllerImpl implements CheckController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckControllerImpl.class);

    /*
     * 当页面请求时，使用画布获取一个验证码图像
     * 返回到页面

     * 接收前端获取验证码的请求，使用画布随机生成一个四位数的验证码图像
     * 将生成的四位数字，数字或字母放在一个session域中使得登录验证的controller中可以获取到该值，判断登陆验证
     * 使用mageIO.write(image, "JPEG", response.getOutputStream());输出图片
     * 使其再前端可以接收再图片显示出来
     * */
    @RequestMapping(value = "/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 设置不缓存图片
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);

        // 指定生成的响应图片,一定不能缺少这句话,否则错误.
        response.setContentType("image/jpeg");
        /*
         * @param
         * 传入生成图像长度和宽度，还有本次会话的请求HttpServletRequest对象request
         * @return
         * 返回一个BufferedImage对象
         * */
        BufferedImage image = ImageUtils.getPicture(80, 35, request);
        // 将图像输出到response输出流中。
        //response.getOutputStream()获取response输出流
        ImageIO.write(image, "JPEG", response.getOutputStream()); // 输出图片
    }

    @RequestMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
//设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            LOGGER.info(code);




//将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
//设置响应头
            response.setHeader("Pragma", "no-cache");
//设置响应头
            response.setHeader("Cache-Control", "no-cache");
//在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
//设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            LOGGER.info("", e);
        }
    }
}
