package com.zlx.clinic.util.mydata;

import com.zlx.clinic.myentity.MyArrange;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 负责存储排号名单
 */
public class MyNumMap {
    //负责存储每个科室的map，每个科室的map在存储每个医生的队列
    private final static Map<String, ConcurrentHashMap<String, LinkedBlockingDeque<MyArrange>>> screenShow
            = new ConcurrentHashMap<>();


    /**
     * 将排号者放入相应科室队列中
     *
     * @param rName
     * @param myArrange
     */
    public static void insertPatient(String rName, MyArrange myArrange) {
        //检查是否存在科室的队列
        if (screenShow.get(rName) == null) {
            synchronized (MyNumMap.class) {
                //初始化科室Map医生map和排队队列
                if (screenShow.get(rName) == null) {
                    //问题volatile不能修饰局部变量
                    LinkedBlockingDeque<MyArrange> myArrangesQueue = new LinkedBlockingDeque<>();
                    ConcurrentHashMap<String, LinkedBlockingDeque<MyArrange>> doctorMap = new ConcurrentHashMap<>();
                    doctorMap.put(myArrange.getDoctor().getdId().toString(),myArrangesQueue);
                    screenShow.put(rName, doctorMap);
                }

            }
            //添加预约
            screenShow.get(rName).get(myArrange.getDoctor().getdId().toString()).offer(myArrange);
        } else {
            //将排号加入到队列中
            screenShow.get(rName).get(myArrange.getDoctor().getdId().toString()).offer(myArrange);
        }

    }

    /**
     * 拿到队列第一个元素
     *
     * @param rName
     */
    public static MyArrange callNum(String rName,String dId) {
        if(screenShow.get(rName)!=null){
            if(screenShow.get(rName).get(dId)!=null){
                MyArrange myArrange = screenShow.get(rName).get(dId).peek();
                System.out.println("++++++++++++++++++++++");
                System.out.println();
                System.out.println();
                System.out.println("叫号===============>>>" + myArrange.toString());
                return myArrange;
            }
        }
     return null;

    }

    /**
     * 叫号三次，将队列首移动值队列尾
     */
    public static void nextNum(String rName,String dId) {
        if(screenShow.get(rName)!=null){
            if(screenShow.get(rName).get(dId)!=null){
                MyArrange poll = screenShow.get(rName).get(dId).poll();
                screenShow.get(rName).get(dId).offer(poll);
            }
        }
    }

    /**
     * 诊治结束在队列中移除
     *
     * @param rName
     */
    public static void removeNum(String rName,String dId) {
        if(screenShow.get(rName)!=null){
            if(screenShow.get(rName).get(dId)!=null){
                screenShow.get(rName).get(dId).poll();
            }
        }

    }

    public void test1(){
        HashMap<String,Integer> s=new HashMap<>();

        System.out.println(s.get("room"));
    }


    /**
     * 将队列中的数据转换为数组
     * @param rName
     * @param dId
     * @return
     */
    public static MyArrange[] getArrange(String rName,String dId){
        MyArrange[] myArranges=null;
        if(screenShow.get(rName)!=null){
            LinkedBlockingDeque<MyArrange> myArrangesQueue = screenShow.get(rName).get(dId);
            if(myArrangesQueue!=null){
                myArranges = (MyArrange[]) myArrangesQueue.toArray();
            }
        }
        return myArranges;
    }

    /**
     * 通过科室查询医生map
     * @param rName
     * @return
     */
    public static ConcurrentHashMap<String, LinkedBlockingDeque<MyArrange>> getArrange(String rName) {
        return screenShow.get(rName);

    }

}
