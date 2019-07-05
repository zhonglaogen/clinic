package com.zlx.clinic;

import com.zlx.clinic.entity.Admin;
import com.zlx.clinic.mapper.AdminMapper;
import com.zlx.clinic.myentity.MyArrange;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class Test extends JFrame
{

    public static void main(String[] args) {
       Integer a=18888;
        System.out.println(a.toString());
    }

    private static int testSwitch() {
        int a=1;
        switch (a){
            case 1:
                System.out.println("++++++++++");return 1;
            case 2:return 2;
            case 3:return 3;
            default:return 0;

        }
    }

    private static void myDateCalculate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = new Date();
        Date date1=new Date();
//        sdf.format(date1);
//        sdf.format(date2);
        long time = date2.getTime();

        long time1 = date1.getTime();
        System.out.println((time1-time)/(1));
        if((time1-time)/(3600*1000)>24){
            System.out.println(time);
            System.out.println(time1);

        }
    }

    private static void testDate(){
        ArrayList<Integer> objects = new ArrayList<Integer>();
        objects.add(1);
        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);

        System.out.println(format);
    }
}
