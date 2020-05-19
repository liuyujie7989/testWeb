package com.liuyujie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/org", method = {RequestMethod.GET, RequestMethod.POST})
public class InterceptorController {

    @RequestMapping("/getOrgId")
    public String getScreenDataUrl() throws IOException {

        System.out.println("controller执行。。");
        return "success";
    }

}
