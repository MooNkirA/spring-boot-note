package com.moon.springboot.mail.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Spring boot 整合 JavaMail 实现发送邮件功能测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-01 21:42
 * @description
 */
@SpringBootTest(args = {"--mail.to=ljemoon@163.com", "--uname=lje888@126.com", "--pwd=44!@ljemon100188"})
public class JavaMailTest {

    // 邮件发送操作对象
    @Autowired
    private JavaMailSender javaMailSender;

    /* 读取配置文件邮件发送地址 */
    @Value("${spring.mail.username}")
    private String from;
    @Value("${mail.to}")
    private String to;

    /* 发送简单邮件 */
    @Test
    public void testSendSimpleMail() {
        // 创建邮件对象
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        // 设置邮件相关参数
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("测试邮件");
        simpleMailMessage.setText("测试邮件正文内容");

        // 发送邮件
        javaMailSender.send(simpleMailMessage);
        System.out.println("发送简单邮件成功");
    }

    /* 发送带附件邮件 */
    @Test
    public void testSendMailWithAttachments() {
        try {
            // 创建MimeMessage邮件对象
            MimeMessage message = javaMailSender.createMimeMessage();
            // 参数true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("测试邮件");
            helper.setText("这是带附件的邮件", true);

            //添加附件
            File f1 = new File("E:\\00-Downloads\\01.jpg");
            File f2 = new File("E:\\00-Downloads\\02.jpg");

            helper.addAttachment(f1.getName(), f1);
            helper.addAttachment("自定义的名称.jpg", f2);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
