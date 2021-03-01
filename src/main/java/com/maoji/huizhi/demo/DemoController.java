package com.maoji.huizhi.demo;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@RestController
@RequestMapping("/test")
public class DemoController {
    @RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws InterruptedException {

       // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        //自定义标题别名
        writer.addHeaderAlias("name", "用户");
        writer.addHeaderAlias("password", "密码");
        writer.addHeaderAlias("role", "权限");
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(2, "52ks网用户信息");
        // 一次性写出内容，使用默认样式，强制输出标题
        List<User> list = ks52user.getUserList();
        writer.write(list);
      //out为OutputStream，需要写出到的目标流

        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        String name =null;
        response.setHeader("Content-Disposition","attachment;filename="+name+".xls");
        ServletOutputStream out= null;
        try {
            out = response.getOutputStream();
            writer.flush(out);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭writer，释放内存
            writer.close();
        }
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }

  public static void main(String[] args) throws IOException {

}}
