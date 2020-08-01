package com.kaikeba.invoice.controller;

import com.kaikeba.invoice.entity.MyFile;
import com.kaikeba.invoice.entity.Students;
import com.kaikeba.invoice.service.StudentsService;
import com.kaikeba.tools.ExcelUtil;
import com.kaikeba.tools.OfficeUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/18 11:37
 */
@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    private static Logger logger = LoggerFactory.getLogger(InvoiceController.class);
    @Autowired
    private StudentsService studentsService;

    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        //StudentsService studentsService = new StudentsServiceImpl();// list<Students> findListStudents()
        List<Students> list = studentsService.findList();
        mv.addObject("lists",list);
        mv.addObject("message","发票管理");
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2(HttpServletResponse response) throws Exception {
        List<Students> list = new ArrayList<>();
        Students students1 = new Students();
        Students students2 = new Students();
        students1.setName("王小王");
        students1.setNum("20201244");
        students1.setSum(239D);
        students2.setName("李小莉");
        students2.setNum("20201233");
        students2.setSum(129D);
        list.add(students1);
        list.add(students2);
//        Response.write(response,list.toString());
        return list.toString();
    }

    @RequestMapping("/uploadJsp")
    public ModelAndView upload(){
        ModelAndView mv = new ModelAndView();
        /*StudentsService studentsService = new StudentsServiceImpl();// list<Students> findListStudents()
        List<Students> list = studentsService.findList();*/
//        mv.addObject("lists",list);
//        mv.addObject("message","发票管理");
        mv.setViewName("/file/upload");
        return mv;
    }


    @RequestMapping(value="/upload",method= RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         //使用对象来接收表单参数
                         MyFile myFile, Model model) throws Exception{
        System.out.println(myFile.getDescription());
        //ModelAndView mv = new ModelAndView();
        //如果文件不为空，写入上传路径
        if(!myFile.getFile().isEmpty()){
//			//上传文件路径这个是相对于这个eclipse项目的路径
//			String path = request.getServletContext().getRealPath("/images/");
            //这是是绝对路径
            //String path = "C:\\Users\\wudan\\Desktop";
            String path = OfficeUtils.getHomePath() + File.separator + "file" + File.separator;
            //上传文件名
            String filename = myFile.getFile().getOriginalFilename();
            //上传路径
            File filepath = new File(path,filename);
            //以下输出的图片路径为
            //System.out.println(filepath);
            //判断路径是否存在，如果不存在就创建一个
            if( !filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }

            //将文件保存到一个目标文件中
            String fileAndUrl = path + File.separator + filename;
            myFile.getFile().transferTo(new File(fileAndUrl));
            //设置文件路径
            myFile.setFileName(filename);
            myFile.setFileUrl(fileAndUrl);
            model.addAttribute("messageFile","文件上传成功");
            model.addAttribute("fileList", new ArrayList<MyFile>(){{
                add(myFile);
            }});
            return "success";

        }else{
            //请求跳转
            return "forward:/main/test.action?code=CN";
        }

    }


    /**
     * 文件下载
     * download处理方法接收到页面传递的文件名filename后，使用Apache Commons FileUpload
     * 组件的FileUtils读取项目的image文件夹下的该文件，并将其构建成ResponseEntity对象返回客户端下载。
     *
     * 使用ResponseEntity对象，可以很方便的定义返回的HTTPHeaders和HttpStatus。下面代码中的
     * MediaType，代表的是Internet Media Type，即互联网媒体类型，也叫做MIME类型。在Http协议消息头
     * 中，使用Content-Type来表示具体请求中的媒体类型信息。HTTPStatus类型代表的是Http协议中的状态。
     */
    @RequestMapping(value="/download")
    public void download(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
        /*//设置对应关系
        List<Students> exportRetContent = studentsService.findList();
        List<String> headers = getSettlementRepairOrderParam();
        try {
            //ExportExcelUtils.createExcelDownload("销项开票捆包", "销项开票捆包", "销项开票捆包", headers.toArray(new String[headers.size()]), exportRetContent);
        } catch (Exception e) {
            logger.error("error = {}",e);
        }*/

        //获取数据
        List<Students> list = studentsService.findList();

        //excel标题
        String[] title = {"学员学号", "学员姓名", "可申请总额", "性别", "手机号","银行卡号"};

        //excel文件名
        String fileName = "学生统计表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "学生统计表";

        String[][] content=new String[list.size()][title.length];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            Students student = list.get(i);
            content[i][0] = student.getNum();
            content[i][1] = student.getName();
            content[i][2] = student.getSum().toString();
            content[i][3] = student.getSexy();
            content[i][4] = student.getMobilePhoneNum();
            content[i][5] = student.getBankNum();
        }

//------------------------以下是向excel中导入查询的数据----------------------
//创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

//响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
