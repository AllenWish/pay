package cn.cgy.controller;

import cn.cgy.pojo.AwClass;
import cn.cgy.pojo.AwUser;
import cn.cgy.service.AwTypeService;
import cn.cgy.service.AwUserService;
import cn.cgy.utils.ResponseUtil;
import cn.cgy.utils.ResultMap;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by allenwish on 2017-11-21.
 */
@Controller
@RequestMapping("/man")
public class ManagerController {
    private static final Logger logger = Logger.getLogger(ManagerController.class);

    @Autowired
    private AwUserService awUserService;
    @Resource
    private AwTypeService typeService;

    @RequestMapping("/managePer")
    public String managePer(Model model) throws Exception{
        List<AwUser> allUser = awUserService.getAllUser();
        model.addAttribute("list",allUser);
        //跳转到对比页
        return "managePer";
    }

    @RequestMapping("/getPaClass")
    @ResponseBody
    public Map<String,Object> getPaClass(){
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("classLevel",1);
        List<Map<String, Object>> awClass = typeService.getAwClass(retMap);
        retMap.put("flag",true);
        retMap.put("msg","success");
        retMap.put("data",awClass);
        return retMap;
    }
    @RequestMapping("/getChClass")
    @ResponseBody
    public Map<String,Object> getChClass(Integer parId){
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("classLevel",2);
        retMap.put("parentId",parId);
        List<Map<String, Object>> awClass = typeService.getAwClass(retMap);
        return ResultMap.returnMap(awClass,true);
    }


    @RequestMapping("/allClass")
    @ResponseBody
    public  Map<String,Object> allClass(AwClass awClass , Model model){
        logger.debug("allClass:"+awClass.toString());
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("flag",true);
        retMap.put("msg","调用了");

        return retMap;
    }
    @RequestMapping("/getData")
    @ResponseBody
    public Map<String,Object> getData(String classType,String dtype){
        logger.info("getData classType:"+classType);
        logger.info("getData dtype:"+dtype);
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("className",classType);
        retMap.put("dtype",dtype);
        List<Map<String, Object>> awClass = typeService.getAwClass(retMap);
        retMap.clear();
        retMap.put("data",awClass);
        retMap.put("success",true);
        return retMap;
    }

    @RequestMapping("/addClass")
    @ResponseBody
    public Map<String,Object> addClass(AwClass awClass , Model model){
        logger.debug("addClass:"+awClass.toString());

        if(awClass.getParentId()==null){
            awClass.setClassLevel("1");
        }else{
            AwClass aClass = typeService.selectByPrimaryKey(awClass.getParentId());
            if(aClass == null){
                awClass.setParentId(null);
                awClass.setClassLevel("1");
            }else{
                try {
                    int le = (Integer.parseInt(aClass.getClassLevel())+1);
                    awClass.setClassLevel(le+"");
                } catch (NumberFormatException e) {
                    awClass.setParentId(null);
                    awClass.setClassLevel("1");
                }
            }
        }
        int insert = 0;
        try {
            insert = typeService.insert(awClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("insert result"+insert);
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("flag",true);
        retMap.put("msg","调用了");

        return retMap;
    }
    @RequestMapping("/updateClass")
    @ResponseBody
    public void updateClass(AwClass awClass , Model model){
        logger.debug("updateClass:"+awClass.toString());
    }
    @RequestMapping("/deleteClass")
    @ResponseBody
    public Map<String,Object> deleteClass(AwClass awClass , Model model){
        logger.debug("deleteClass:"+awClass.toString());
        typeService.deleteByPrimaryKey(awClass.getId());
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("flag",true);
        retMap.put("msg","调用了");
        return retMap;
    }

    @RequestMapping("/goperadd")
    public String goperadd(Integer id, HttpServletRequest request){
        AwUser awUser = new AwUser();
        if(id!=null&&id>=0){
            awUser = awUserService.getUserById(id);
        }
        request.setAttribute("user",awUser);
        return "perAdd";
    }
    @RequestMapping("/dopersave")
    @ResponseBody
    public Map<String,Object> dopersave(AwUser awUser){
        logger.debug("awUser:"+awUser.toString());
        try {
            String username = awUser.getUsername();
            AwUser user = new AwUser();
            user.setUsername(username);
            List<AwUser> awUsers = awUserService.getUser(user);
            if(awUsers.size()>0){
                return ResultMap.errorMap(username+"已存在");
            }
            if(awUser.getId()==null||awUser.getId()==0){
                awUserService.insertUser(awUser);
                logger.debug("addPer:"+awUser.getUsername());
            }else{
                awUserService.updateUser(awUser);
                logger.debug("updateUser:"+awUser.getUsername());
            }
        } catch (Exception e) {
           return ResultMap.errorMap(e.getMessage());
        }
        return ResultMap.successMap("/managePer");
        //return "redirect:/managePer";
    }

    @RequestMapping("/allPer")
    @ResponseBody
    public Map<String,Object> allPer(AwUser awUser , Model model, HttpServletResponse response) throws Exception {

        List<AwUser> allUser = awUserService.getUser(awUser);

        return ResultMap.successMap(allUser);

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
