package com.zlx.clinic.controller;

import com.zlx.clinic.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("/info/all")
    @ResponseBody
    public Map<String,Object> selectInfoAll(){
        return infoService.selectAllInfo();
    }
}
