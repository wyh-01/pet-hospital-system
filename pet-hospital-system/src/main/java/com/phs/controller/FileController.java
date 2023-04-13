package com.phs.controller;
import com.phs.service.facade.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {

    @Autowired
    private FileUploadService fileUploadService;
    /**
     * 文件上传具体实现方法;
     *
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public ResponseEntity handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String returnUrl;
            try {
                /*
                 * 这段代码执行完毕之后，图片上传到了工程的跟路径； 大家自己扩散下思维，如果我们想把图片上传到
                 * d:/files大家是否能实现呢？ 等等;
                 * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如： 1、文件路径； 2、文件名；
                 * 3、文件格式; 4、文件大小的限制;
                 */
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(
                                file.getOriginalFilename())));
                returnUrl = fileUploadService.upload(file);
                System.out.println(file.getName());
                //out.write(file.getBytes());
                //out.flush();
                //out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return new ResponseEntity("上传失败," + e.getMessage(), HttpStatus.BAD_REQUEST);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity("上传失败," + e.getMessage(), HttpStatus.BAD_REQUEST);
            }
            Map<String, String> map = new HashMap<String, String>();
            map.put("message", "上传成功");
            map.put("url", returnUrl);
            return new ResponseEntity<>(map, HttpStatus.OK);

        } else {
            return new ResponseEntity("上传失败，因为文件是空的.", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/uploadMulti")
    @ResponseBody
    public ResponseEntity uploadMulti(@RequestParam("files") MultipartFile[] files) {
        if(!isEmpty(files)) {
            for (MultipartFile file : files) {
                fileUploadService.upload(file);
            }
            return new ResponseEntity("上传成功", HttpStatus.OK);
        }else{
            return new ResponseEntity("上传失败，因为文件是空的.", HttpStatus.BAD_REQUEST);
        }
    }

    private boolean isEmpty(MultipartFile files[]){
        if(files.length == 1 && files[0].isEmpty()){
            return true;
        }
        return  false;
    }
}
