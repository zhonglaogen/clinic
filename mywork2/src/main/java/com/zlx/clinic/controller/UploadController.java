package com.zlx.clinic.controller;

import com.zlx.clinic.service.ExcelService;
import com.zlx.clinic.util.POIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class UploadController {

    @Autowired
    private ExcelService excelService;

    @RequestMapping(method = RequestMethod.POST ,value="/upload/medicine")
    private String uploadWesternMedicine(MultipartFile file) throws IOException {
        try{
            List<String[]> list = POIUtil.readExcel(file); //这里得到的是一个集合，里面的每一个元素是String[]数组
            excelService.saveBath(list);//service实现方法
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("上传文件错误！");
            return "redirect:/d upload.jsp";
        }
        return "redirect:/d upload.jsp";
    }
}
