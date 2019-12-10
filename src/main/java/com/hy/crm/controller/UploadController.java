package com.hy.crm.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
@Controller
public class UploadController {


    @Resource
    HttpServletRequest request;

    /**
     * @return  返回相对路径RelativePath
     */
    public String RelPath() {
        String path = request.getContextPath();
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    }

    /**
     * @return  返回服务器目录的真实路径
     */
    public String RealPath() {
        return request.getSession().getServletContext().getRealPath("/");
    }

    /**
     *  单文件上传
     *
     * @param imageFile
     * @param request
     * @return
     */
    @RequestMapping(value = "/singleUpload.do",method= RequestMethod.POST)
    @ResponseBody
    public String singleUpload(@RequestParam("file") MultipartFile imageFile, HttpServletRequest request){//,

        String filename = imageFile.getOriginalFilename();

        File dir = new File(RealPath()+"upload/");//1.新建一个文件夹对象
        if(!dir.exists()){              //2.检查路径下upload文件夹是否存在
            dir.mkdirs();
        }

        System.out.println("文件上传到:"+RelPath()+"upload/"+ filename);

        File targetFile = new File(RealPath()+"upload/"+ filename);//3.在文件夹下新建一个filename文件的文件对象,此处新建文件应该新建在确切的物理路径下

        if(!targetFile.exists()){//4.判断真实路径下是否存在filename文件
            try {
                targetFile.createNewFile();//5.在真实路径下创建filename空文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            imageFile.transferTo(targetFile);//6.复制文件到真实路径下
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("真实路径:"+RealPath()+"upload/");
        System.out.println("相对路径:"+RelPath()+"upload/");
        request.getSession().setAttribute("filename",filename);
        return "1";            //非安全目录下使用(可用)
        //return "redirect:"+RealPath()+"upload/"+filename;                 //重定向到真实地址(不可用)
        //return "redirect:http://localhost:8080/SpringMvcTest/upload/"+filename;
    }

    /**
     * 多文件上传
     * @param request
     * @return
     */
    @RequestMapping("/multiUpload")
    public String multiUpload(HttpServletRequest request){

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;//1、将请求进行转义

        Map<String, MultipartFile> files = multipartHttpServletRequest.getFileMap();//2、获取同一表单提交过来的所有文件

        //3、在真实路径创建文件
        File dir = new File(RealPath()+"upload/");
        if(!dir.exists()) {
            dir.mkdirs();
        }

        List<String> fileList = new ArrayList<String>();//4、将上传的文件的相对地址保存在一个列表中(客户端只能请求服务器的相对地址)

        for(MultipartFile file : files.values()) {  //5、在服务器的绝对地址下新建文件,并将上传的文件复制过去,将相对路径保存进List列表中,服务器的相对路径和绝对路径是相互映射的，客户端只能请求相对路径
            File targetFile = new File(RealPath()+"upload/" + file.getOriginalFilename());
            if(!targetFile.exists()) {
                try {
                    targetFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    file.transferTo(targetFile);
                    fileList.add(RelPath()+"upload/"+file.getOriginalFilename());
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                fileList.add(RelPath()+"upload/"+file.getOriginalFilename());//文件如果存在直接访问
            }

        }
        System.out.println(fileList);
        request.setAttribute("files", fileList);

        return "/WEB-INF/jsp/multiUploadResult.jsp";
    }
}
