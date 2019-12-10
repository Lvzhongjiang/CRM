package com.hy.crm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownloadController {

    @Resource
    HttpServletRequest request;

    @Resource
    HttpServletResponse response;

    @RequestMapping("/download.do")
    public String download(@RequestParam String fileName){

        response.setContentType("text/html;charset=utf-8");//1.设置响应的文件类型和文件编码

        try {
            request.setCharacterEncoding("UTF-8");//2.确保请求的编码类型为UTF-8,不然文件下载后有可能因为类型不一致出现乱码
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        String ctxPath = request.getSession().getServletContext().getRealPath("/")+"upload/";
        String downLoadPath = ctxPath + fileName;
        System.out.println(downLoadPath);

        try{
            long fileLength = new File(downLoadPath).length();

            //3.设置响应头文件内容,文件类型、弹出下载对话框、文件大小
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            response.setHeader("Content-Length", String.valueOf(fileLength));

            bis = new BufferedInputStream(new FileInputStream(downLoadPath));//4.新建一个输入流缓存对象,并将文件输入流对象传递进去,将文件路径传递进文件输入流对象中，这是一个逐步处理的过程
            bos = new BufferedOutputStream(response.getOutputStream());//5.新建一个输出流缓存对象,将服务器响应输出流对象至于其中
            byte[] buff = new byte[2048];//6.新建一个缓存
            int bytesRead;              //7.内容字节总数
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {//8.输入到到buff缓存中,当文件为空是read()会return -1,否则返回读取的字节总数
                bos.write(buff, 0, bytesRead);//9.将buff的字节写到响应体的输出流中，输出流持续输出到客户端
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                try {
                    bis.close();//10.关闭缓存输入流对象
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            if (bos != null)
                try {
                    bos.close();//10.关闭缓存输出流对象
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return null;
    }
}
