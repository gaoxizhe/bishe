package com.example.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.concurrent.*;

public class MyMailUtil {

    String contents = "";

    public MyMailUtil(String code) {

        contents = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>激活码</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1 style=\"display: inline\">您的激活码为：</h1>\n" +
                "    <h1 style=\"color: deepskyblue;display: inline;margin-left: 20px\">" + code + "</h1>\n" +
                "</body>\n" +
                "</html>";
    }

    public MyMailUtil() {
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void sendMail(String addr) {
        long l = System.currentTimeMillis();
        System.out.println("start====================");


            ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat(addr).build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            send(Thread.currentThread().getName());
        });
        singleThreadPool.shutdown();


        System.out.print("消耗时间： " + (System.currentTimeMillis() - l )+ " ms");
        System.out.println("end====================");

    }

    private void send(String addr) {
        // 配置
        Properties prop = new Properties();
        // 设置邮件服务器主机名，这里是163
        prop.put("mail.host", "smtp.163.com");
        // 发送邮件协议名称
        prop.put("mail.transport.protocol", "smtp");
        // 是否认证
        prop.put("mail.smtp.auth", true);

        try {
            // SSL加密
            MailSSLSocketFactory sf = null;
            sf = new MailSSLSocketFactory();
            // 设置信任所有的主机
            sf.setTrustAllHosts(true);
            prop.put("mail.smtp.ssl.enable", "true");
            prop.put("mail.smtp.ssl.socketFactory", sf);

            // 创建会话对象
            Session session = Session.getDefaultInstance(prop, new Authenticator() {
                // 认证信息，需要提供"用户账号","授权码"
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("gaoxizhe1238@163.com", "IHNMKNUYGJEKYXTK");
                }
            });
            // 是否打印出debug信息
            session.setDebug(false);

            // 创建邮件
            Message message = new MimeMessage(session);
            // 邮件发送者
            message.setFrom(new InternetAddress("gaoxizhe1238@163.com"));
            // 邮件接受者
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(addr));
            // 邮件主题
            message.setSubject("激活邮件");

            //测试数据
//            String content = "<html><head></head><body><h1>请点击连接激活</h1><h3><a href='http://localhost:8080/active?code="
//                    + 4444 + "'>http://localhost:8080/active?code=" + 4444 + "</href></h3></body></html>";

            message.setContent(contents, "text/html;charset=UTF-8");
            // Transport.send(message);
            // 邮件发送
            Transport transport = session.getTransport();
            transport.connect();
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}