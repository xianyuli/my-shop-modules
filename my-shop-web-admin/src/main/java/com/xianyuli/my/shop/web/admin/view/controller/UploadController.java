package com.xianyuli.my.shop.web.admin.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName: UploadController
 * @Description: java类作用描述
 * @Author: LW
 */
@Controller
public class UploadController {

    public static final String UPLOAD_PATH = "/static/upload/";

    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map upload(MultipartFile[] dropFiles, HttpServletRequest request) {
        List<String> nameList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>(8);
        for (MultipartFile dropFile : dropFiles) {
            String targetName = wirteFile(dropFile, request);
            String filename = String.format("%s%s", UPLOAD_PATH, targetName);
            String filepath = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + filename;
            nameList.add(filepath);
            //dropzone上传文件限制为一个
            map.put("filename", filename);
        }
        map.put("errno", 0);
        //wangedit上传一个或者多个文件，全域名
        map.put("data", nameList);
        return map;
    }

    private String wirteFile(MultipartFile dropFile, HttpServletRequest request) {
        //文件存放路径
        String realPath = request.getServletContext().getRealPath(UPLOAD_PATH);
        //获取文件后缀
        String name = dropFile.getOriginalFilename();
        String nameSuffix = name.substring(name.lastIndexOf("."));
        String targetName = UUID.randomUUID() + nameSuffix;
        System.out.println(nameSuffix);
        File fileDir = new File(realPath);
        //文件将是否存在
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        //目标文件
        File targetFile = new File(realPath, targetName);
        try {
            //写入目标文件
            dropFile.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return targetName;
    }


}
