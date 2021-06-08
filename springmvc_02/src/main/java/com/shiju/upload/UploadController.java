package com.shiju.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author shiju
 * @date 2021/06/08 16:28
 */
@Controller
@RequestMapping("/uploadController")
public class UploadController {
    @RequestMapping("upload")
    @ResponseBody
    public void doUpload(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException {
        for (MultipartFile multipartFile : files) {
            if (!multipartFile.isEmpty()) {
                //获取要保存的目录路径
                String realPath = request.getServletContext().getRealPath("/upload");
                //获取文件名
                String filename = multipartFile.getOriginalFilename();
                //用UUID生成随机文件名
                String uuid = UUID.randomUUID().toString().replace("-", "");
                //获取后缀名
                String suffix = filename.substring(filename.lastIndexOf("."));
                //组合成新的文件名
                filename = uuid + suffix;
                //将文件保存到服务器硬盘中
                multipartFile.transferTo(new File(realPath, filename));
            }
        }
    }
}
