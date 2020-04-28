package com.liuyujie.controller;


import com.liuyujie.bo.User;
import com.ohaotian.plugin.base.annotation.BusiResponseBody;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/xaScreen", method = {RequestMethod.GET, RequestMethod.POST})
public class XAScreenDataController {
  /*  @Value("${oss.endpoint}")
    private String endpoint;*/
  Logger logger = LoggerFactory.getLogger(XAScreenDataController.class);


    private  static  String accessKeyId;

    @Value("${oss.accessKeyId}")
    public  void setAccessKeyId(String accessKeyId) {
        XAScreenDataController.accessKeyId = accessKeyId;
    }

    @RequestMapping("/getXAScreen")
    public String getScreenDataUrl() throws IOException {
        User user1 = new User("张三", 10, "北大", "1");
        User user2 = new User("李四", 15, "西大", "2");
        User user3 = new User("王五", 12, "南大", "3");
        User user4 = new User("马六", 15, "东大", "4");
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

      ByteArrayOutputStream stream = DateToExcel.exportProjectList(users);

       String url = DateToExcel.uploadWorkbook(stream, "西安市数字大屏历史数据.xlsx");
        return null;

    }

    public static void main(String[] args) throws IOException {

        User user1 = new User("张三", 10, "北大", "1");
        User user2 = new User("李四", 15, "西大", "2");
        User user3 = new User("王五", 12, "南大", "3");
        User user4 = new User("马六", 15, "东大", "4");
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);




        ByteArrayOutputStream byteArrayOutputStream = DateToExcel.exportProjectList(users);
        /**
         * 转base64
         */
        byte[] bytes = byteArrayOutputStream.toByteArray();
        String base64String = Base64.encodeBase64String(bytes);

        // String uri = DateToExcel.uploadWorkbook(stream, "西安市数字大屏历史数据.xlsx");

        System.out.println(base64String);
    }

    /**
     * @RequestParam 前台参数名称与后台接收参数变量名称不一致的问题，等价于request.getParam
     * @param name
     * @return
     */
    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    @BusiResponseBody
    public Object test1(@RequestParam("name")String name, @RequestParam("name")String  school)  {
        User user = new User();
        user.setName(name);
        user.setSchool(school
        );
        return user;
    }
    /**
     * @RequestBody
     * @param
     * @return
     */
    @RequestMapping(value = "/test2",method = {RequestMethod.POST,RequestMethod.GET})
    @BusiResponseBody
    public Object test2(@RequestBody User  user)  {
        System.out.println(user);
        return user.toString();
    }

    /**
     * @RequestBody
     * @param
     * @return
     */
    @RequestMapping(value = "/test3",method = {RequestMethod.POST,RequestMethod.GET})
    @BusiResponseBody
    public Object test3(User  user)  {
        System.out.println(user);
        return user.toString();
    }
}
