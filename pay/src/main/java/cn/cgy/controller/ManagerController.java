package cn.cgy.controller;

import cn.cgy.pojo.AwClass;
import cn.cgy.pojo.AwUser;
import cn.cgy.service.AwUserService;
import cn.cgy.utils.ResponseUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by allenwish on 2017-11-21.
 */
@Controller
@RequestMapping("/man")
public class ManagerController {
    private static final Logger logger = Logger.getLogger(ManagerController.class);

    @Autowired
    private AwUserService awUserService;

    @RequestMapping("/managePer")
    public String managePer(Model model) throws Exception{
        List<AwUser> allUser = awUserService.getAllUser();
        model.addAttribute("list",allUser);
        //跳转到对比页
        return "managePer";
    }




    @RequestMapping("/allClass")
    @ResponseBody
    public void allClass(AwClass awClass , Model model){
        logger.debug("allClass:"+awClass.toString());
    }
    @RequestMapping("/addClass")
    @ResponseBody
    public void addClass(AwClass awClass , Model model){
        logger.debug("addClass:"+awClass.toString());
    }
    @RequestMapping("/updateClass")
    @ResponseBody
    public void updateClass(AwClass awClass , Model model){
        logger.debug("updateClass:"+awClass.toString());
    }
    @RequestMapping("/deleteClass")
    @ResponseBody
    public void deleteClass(AwClass awClass , Model model){
        logger.debug("deleteClass:"+awClass.toString());
    }

    @RequestMapping("/allPer")
    @ResponseBody
    public void allPer(AwUser awUser , Model model, HttpServletResponse response) throws Exception {
        logger.debug("awUser:"+awUser.toString());
        List<AwUser> allUser = awUserService.getAllUser();
        logger.debug("allUser:"+allUser.toString());
        try {
            ResponseUtil.write(response, JSONObject.fromObject(allUser));
        } catch (Exception e) {
            ResponseUtil.write(response,"出错了");
        }

    }
    @RequestMapping("/getUser")
    @ResponseBody
    public void getUser(AwUser awUser , Model model,HttpServletResponse response){
        logger.debug("getUser:"+awUser.toString());
        JSONObject json = new JSONObject();
        AwUser user = awUserService.getUserById(awUser.getId());
        json = JSONObject.fromObject(user);
        ResponseUtil.write(response,json);
    }

    @RequestMapping("/addPer")
    @ResponseBody
    public void addPer(AwUser awUser , Model model,HttpServletResponse response ) {
        logger.debug("awUser:"+awUser.toString());
        JSONObject json = new JSONObject();
        json.put("success","success");
        json.put("msg","操作成功");
        try {
            if(awUser.getId()==null||awUser.getId()==0){
                awUserService.insertUser(awUser);
                logger.debug("addPer:"+awUser.getUsername());
            }else{
                awUserService.updateUser(awUser);
                logger.debug("updateUser:"+awUser.getUsername());
            }
            ResponseUtil.write(response,json);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("success","error");
            json.put("msg",e.getMessage());
            ResponseUtil.write(response,json);
        }
    }
    @RequestMapping("/updatePer")
    @ResponseBody
    public void updatePer(AwUser awUser , Model model){
        logger.debug("awUser:"+awUser.toString());
    }
    @RequestMapping("/deletePer")
    public void deletePer(AwUser awUser , Model model,HttpServletResponse response) {
        logger.debug("deletePer:"+awUser.toString());
        JSONObject json = new JSONObject();
        json.put("success","success");
        json.put("msg","删除成功");
        try {
            awUserService.delete(awUser.getId());
            logger.debug("deletePer:"+awUser.getId());
            ResponseUtil.write(response,json);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("success","error");
            json.put("msg",e.getMessage());
            ResponseUtil.write(response,json);
        }
    }
}
