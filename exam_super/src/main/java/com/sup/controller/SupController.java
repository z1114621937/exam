package com.sup.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Student;
import com.mbg.exam.mapper.LogsMapper;
import com.sup.service.LogsImplService;
import com.sup.service.StudentImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/sup")
public class SupController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    LogsImplService logsImplService;

    @Autowired
    StudentImplService studentImplService;
    /**
     * 查找管理员
     * @return
     */
    @RequestMapping("/selectguan")
    public IPage<Map> selectguan() {
        return studentImplService.selectguan();
    }


    /**
     * 开启管理员  （用软删除字段代表）
     * @return
     */
    @RequestMapping("/permissions")
    public CommonResult permissions(@RequestParam int id) {
        return studentImplService.permissions(id);
    }

    /**
     * 开启管理员  （用软删除字段代表）
     * @return
     */
    @RequestMapping("/nopermissions")
    public CommonResult nopermissions(@RequestParam int id) {
        return studentImplService.nopermissions(id);
    }




    @RequestMapping("/getIpAddr")
    private CommonResult getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return CommonResult.success(ip,"查找ip成功");

    }

    /**
     * 增加超级管理员的log日志
     * @param id
     * @param ip
     * @param address
     * @param date
     * @return
     */
    @RequestMapping("/logininfo")
    public CommonResult logininfo(@RequestHeader("memberId") Integer id,@RequestParam String ip,
                                  @RequestParam String address,@RequestParam String date) {
        Student student=studentImplService.getById(id);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=dateFormat.format(new Date());
        System.out.println(time);

        return logsImplService.insertip(time,student.getName(),ip,address,date);
    }


    @RequestMapping("/selectlog")
    public IPage<Map> selectlog() {

      return logsImplService.selectlog();
    }



}
