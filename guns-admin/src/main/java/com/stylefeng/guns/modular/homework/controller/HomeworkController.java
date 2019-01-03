package com.stylefeng.guns.modular.homework.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.homework.service.IHomeworkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * 控制器
 *
 * @author maguohao
 * @Date 2018年11月17日20:27:22
 */
@Controller
@RequestMapping("/homework")
public class HomeworkController extends BaseController {

    private String PREFIX = "/homework/";

    @Resource
    private IHomeworkService iHomeworkService;

    @RequestMapping("")
    public String index() {
        String roleId = ShiroKit.getUser().getRoleNames().get(0);

        if(roleId == "6"){
            return PREFIX + "homework_teacher.html";
        }else if(roleId == "7"){
            return PREFIX + "homework_student.html";
        }else{
            return PREFIX + "homework_teacher.html";
        }
    }

    @RequestMapping("/list/{id}")
    public String list(@PathVariable String id, Model model) {
        model.addAttribute("id",id);
        return PREFIX + "homework_list.html";
    }

    @RequestMapping("/student_list/{id}")
    public String student_list(@PathVariable String id, Model model) {
        model.addAttribute("id",id);
        return PREFIX + "homework_student_list.html";
    }

    @RequestMapping("/upload_student_list/{id}")
    public String upload_student_list(@PathVariable String id, Model model) {
        model.addAttribute("id",id);
        return PREFIX + "homework_upload_student_list.html";
    }

    @RequestMapping("/upload")
    public String upload() {
        return PREFIX + "homework_upload.html";
    }

    @RequestMapping("/download")
    public String download() {
        return PREFIX + "homework_download.html";
    }

    @RequestMapping("/download_student")
    public String download_student() {
        return PREFIX + "homework_download_student.html";
    }

    @RequestMapping("/homework_add/{folderId}")
    public String homework_add(@PathVariable String folderId,Model model) {
        model.addAttribute("folderId",folderId);
        return PREFIX + "homework_teacher_add.html";
    }

    @RequestMapping("/homework_student_add/{folderId}")
    public String homework_student_add(@PathVariable String folderId,Model model) {
        model.addAttribute("folderId",folderId);
        return PREFIX + "homework_student_add.html";
    }

    @RequestMapping("/homework_edit")
    public String homework_edit() {
        return PREFIX + "homework_teacher_edit.html";
    }


    @RequestMapping(value = "/getHomeworkList/{id}")
    @ResponseBody
    public List<Map<String, Object>> getHomeworkList(@PathVariable String id) {

        List<Map<String, Object>> getHomeworkList = null;
        try {
            getHomeworkList = this.iHomeworkService.getHomeworkList(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return getHomeworkList;
    }

    @RequestMapping(value = "/getHomeworkList_student")
    @ResponseBody
    public List<Map<String, Object>> getHomeworkList_student() {

        List<Map<String, Object>> getHomeworkList = null;
        try {
            getHomeworkList = this.iHomeworkService.getHomeworkList_student();
        }catch (Exception e){
            e.printStackTrace();
        }

        return getHomeworkList;
    }

    @RequestMapping(value = "/insertHomework")
    @ResponseBody
    public Integer insertHomework(@RequestBody Map map) {

        Integer no = 0;
        try {
            no = this.iHomeworkService.insertHomework(map);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }

    /**
     * 实现文件上传
     * */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile file,@RequestParam("folderId") String folderId){
        if(file.isEmpty()){
            return "保存失败";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        String path = "E:/test" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        Map map = new HashMap();
        map.put("folderId",folderId);
        map.put("homeworkName",fileName);
        map.put("filePath",path);
        map.put("fileSize","600KB");
        map.put("fileType","word");
        map.put("status","上传成功");
        map.put("userId","45");
        try {
            file.transferTo(dest); //保存文件
            this.iHomeworkService.insertHomework(map);
            return "保存成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "保存失败";
        } catch (IOException e) {
            e.printStackTrace();
            return "保存失败";
        }
    }

    @RequestMapping("downLoadFile")
    public void  downLoadFile(HttpServletResponse response)throws Exception{
//        String filename="数学作业.doc";
//        String filePath = "E:/test" ;
//        File file = new File(filePath + "/" + filename);
//        if(file.exists()){ //判断文件父目录是否存在
//            response.setContentType("application/force-download");
//            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);
//
//            byte[] buffer = new byte[1024];
//            FileInputStream fis = null; //文件输入流
//            BufferedInputStream bis = null;
//
//            OutputStream os = null; //输出流
//            try {
//                os = response.getOutputStream();
//                fis = new FileInputStream(file);
//                bis = new BufferedInputStream(fis);
//                int i = bis.read(buffer);
//                while(i != -1){
//                    os.write(buffer);
//                    i = bis.read(buffer);
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println("----------file download" + filename);
//            try {
//                bis.close();
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;

        String path = "E:/test" ;
        try {
            // 取得文件名。
            String filename = "数学作业.doc";
            // path是指欲下载的文件的路径。
            File file = new File(path +"/"+ filename);


            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path+"/"+ filename));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 实现文件上传
     * */
    @RequestMapping("student_fileUpload")
    @ResponseBody
    public String student_fileUpload(@RequestParam("fileName") MultipartFile file,@RequestParam("folderId") String folderId){
        if(file.isEmpty()){
            return "保存失败";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        String path = "E:/student_test" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        Map map = new HashMap();
        map.put("folderId",folderId);
        map.put("homeworkName",fileName);
        map.put("filePath",path);
        map.put("fileSize","600KB");
        map.put("fileType","word");
        map.put("status","上传成功");
        map.put("userId","45");
        try {
            file.transferTo(dest); //保存文件
            this.iHomeworkService.insertHomework_student(map);
            return "保存成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "保存失败";
        } catch (IOException e) {
            e.printStackTrace();
            return "保存失败";
        }
    }

    @RequestMapping("student_downLoadFile")
    public void  student_downLoadFile(HttpServletResponse response)throws Exception{
//        String filename="数学作业.doc";
//        String filePath = "E:/test" ;
//        File file = new File(filePath + "/" + filename);
//        if(file.exists()){ //判断文件父目录是否存在
//            response.setContentType("application/force-download");
//            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);
//
//            byte[] buffer = new byte[1024];
//            FileInputStream fis = null; //文件输入流
//            BufferedInputStream bis = null;
//
//            OutputStream os = null; //输出流
//            try {
//                os = response.getOutputStream();
//                fis = new FileInputStream(file);
//                bis = new BufferedInputStream(fis);
//                int i = bis.read(buffer);
//                while(i != -1){
//                    os.write(buffer);
//                    i = bis.read(buffer);
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println("----------file download" + filename);
//            try {
//                bis.close();
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;

        String path = "E:/student_test" ;
        try {
            // 取得文件名。
            String filename = "数学作业.doc";
            // path是指欲下载的文件的路径。
            File file = new File(path +"/"+ filename);


            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path+"/"+ filename));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
