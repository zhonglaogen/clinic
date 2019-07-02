package com.zlx.clinic.util;

import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class MyUtil {

//    private static final Logger l = (Logger) LoggerFactory.getLogger(MyUtil.class);
    /**
     * 将password转为md5形式的编码
     * @param password
     * @return
     */
    public static byte[] getcode(String password)throws Exception{
        byte[] md5;
            MessageDigest ms=MessageDigest.getInstance("MD5");
            md5=ms.digest(password.getBytes());
            return md5;
    }
    public static SimpleDateFormat changeDate(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.format(date);
        return simpleDateFormat;
    }
}
