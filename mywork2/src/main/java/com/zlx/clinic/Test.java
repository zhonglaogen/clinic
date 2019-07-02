package com.zlx.clinic;

import com.zlx.clinic.entity.Admin;
import com.zlx.clinic.mapper.AdminMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
public class Test
{

    private static void testDate() {
        ArrayList<Integer> objects = new ArrayList<Integer>();
        objects.add(1);
        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);

        System.out.println(format);
    }
}
