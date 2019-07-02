package com.zlx.clinic.util;

import java.util.Properties;
import java.util.Random;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * 邮箱注册
 */
public class Mail {

    public static void main(String args[]) {
        qqSendMail("603943860@qq.com", "jkrouwkwpbazbajj", "smtp.qq.com",
                "479230207@qq.com");

//        foxmailSendMail("发件邮箱", "密码",
//                "邮件服务器", "收件人邮箱");
    }

    /**
     * Foxmail邮箱验证
     *
     * @param fromMail     发件人邮箱
     * @param fromPwd      发件人密码
     * @param mailServicer 邮件服务器
     * @param toMail       收件人邮箱
     * @return 收件人邮箱+验证码
     */
    public static String foxmailSendMail(String fromMail, String fromPwd,
                                         String mailServicer, String toMail) {
        String code = createCode();
        StringBuffer st = new StringBuffer();
        // 获取系统属性
        Properties properties = new Properties();
        // 身份验证开启
        properties.put("mail.smtp.auth", "true");
        // debug模式
        properties.put("mail.debug", "true");
        // 邮件服务器
        properties.setProperty("mail.host", mailServicer);
        // 邮箱传送协议
        properties.setProperty("mail.transport.protocol", "smtp");
        // 获取默认session对象
        Session session = Session.getInstance(properties);
        session.setDebug(true);
        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // 头部头字段
            message.setFrom(new InternetAddress(fromMail));
            // 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    toMail));
            // 头部头字段
            message.setSubject("请及时验证邮箱");
            // 设置消息体
            message.setText("邮箱验证码：" + code);
            Transport transport = session.getTransport();
            transport.connect(mailServicer, fromMail, fromPwd);
            transport.sendMessage(message, new Address[]{new InternetAddress(
                    toMail)});
            transport.close();
            st.append(toMail + ":" + code);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return st.toString();
    }

    /**
     * QQ邮箱验证
     *
     * @param fromMail     发件人邮箱
     * @param fromPwd      发件人密码
     * @param mailServicer 邮件服务器
     * @param toMail       收件人邮箱
     * @return 收件人邮箱+验证码
     */
    public static String qqSendMail(String fromMail, String fromPwd,
                                    String mailServicer, String toMail) {
        String code = createCode();
        StringBuffer st = new StringBuffer();
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", mailServicer);
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");
        try {
            // 添加ssl加密，qq需要传输过程ssl加密
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);
            Session session = Session.getInstance(props);
            // 邮件内容部分
            Message msg = new MimeMessage(session);
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    toMail));
            // 头部头字段
            msg.setSubject("请及时验证邮箱");
            // 设置消息体
            msg.setText("邮箱验证码：" + code);
            // 邮件发送者
            msg.setFrom(new InternetAddress(fromMail));
            // 发送邮件
            Transport transport = session.getTransport();
            transport.connect(mailServicer, fromMail, fromPwd);
            transport.sendMessage(msg, new Address[]{new InternetAddress(
                    toMail)});
            transport.close();
            st.append(toMail + ":" + code);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return st.toString();
    }

    /**
     * 产生四位随机数
     *
     * @return
     */
    public  static String createCode() {
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if (randLength < 4) {
            for (int i = 1; i <= 4 - randLength; i++){
                fourRandom = "0" + fourRandom;
            }

        }
      return fourRandom;
    }
}
