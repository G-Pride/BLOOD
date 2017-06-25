package com.dfish.controller;

import com.dfish.domain.vo.UploadFileResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/10 0010.
 */

@Controller
@RequestMapping(value = "/upload")
public class UploadFileController {

    //获取上传的文件夹，具体路径参考application.properties中的配置
    @Value("${dfish.web.fileuploadpath}")
    private String fileUploadPath;


    /**
     * GET请求
     * 上传页面，也将显示已经存在的文件
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/index")
    public String index(Model model) {
        //获取已存在的文件
        File[] files = new File(fileUploadPath).listFiles();
        model.addAttribute("files", files);
        return "web/index";
    }

    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public MappingJacksonValue upload(@RequestParam("file") MultipartFile file) {
        UploadFileResult result = new UploadFileResult();
        Date d = new Date();
        SimpleDateFormat datename = new SimpleDateFormat("yyyyMMddHHmmss");
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String savedFileName = file.getOriginalFilename();
                String fsaveFileName = datename.format(d);
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static" + fileUploadPath + fsaveFileName + savedFileName)));
                stream.write(bytes);
                stream.close();
                result.setUrl(fileUploadPath + fsaveFileName + savedFileName);
                result.setFileName(savedFileName);
                result.setSuccess(1);
                return new MappingJacksonValue(result);
            } catch (Exception e) {
                result.setSuccess(0);
                result.setMessage("文件上传失败！("+e.getMessage()+")");
                return new MappingJacksonValue( result);
            }
        } else {
            return new MappingJacksonValue( result);
        }
    }

}
