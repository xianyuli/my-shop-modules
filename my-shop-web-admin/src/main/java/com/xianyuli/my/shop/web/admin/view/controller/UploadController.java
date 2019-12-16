package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    public Map upload(MultipartFile dropFile, HttpServletRequest request) {
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
        String filename = String.format("%s%s", UPLOAD_PATH, targetName);
        String filepath = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + filename;
        Map map = new HashMap();
        map.put("errno", 0);
        map.put("filename", filename);
        //wangedit上传文件
        map.put("data", new String[]{filepath});
        return map;
    }


}
