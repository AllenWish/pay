package cn.cgy.template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Allenwish on 2017-11-23.
 */
public class TemplateUtil {
    private Configuration cfg;

    public void init(HttpServletRequest request) throws Exception{
        cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        //cfg.setClassForTemplateLoading(this.getClass(),"/com/allen/ftl");
        cfg.setServletContextForTemplateLoading(request.getServletContext(),"/ftl");
    }
    public void init() throws Exception{
        cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        cfg.setClassForTemplateLoading(this.getClass(),"/com/allen/ftl");
    }
    public TemplateUtil(){
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TemplateUtil(HttpServletRequest req){
        try {
            init(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void process() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("username","allenwish");
        map.put("name","tracyYou");
        map.put("age",24);
        map.put("url","http://www.allenwish.com/");
        Template template = cfg.getTemplate("allen.ftl");
        //在模版上执行插值操作，并输出到制定的输出流中
       template.process(map, new OutputStreamWriter(System.out));


    }
    public void process(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("username","allenwish");
        map.put("name","tracyYou");
        map.put("age",24);
        map.put("url","http://www.allenwish.com/");
        Template template = cfg.getTemplate("allen.ftl");
        template.setEncoding("UTF-8");
        //在模版上执行插值操作，并输出到制定的输出流中
        // template.process(map, new OutputStreamWriter(System.out));
        response.setContentType("text/html; charset=" + template.getEncoding());
        Writer out = response.getWriter();
        //合并数据模型和模板，并将结果输出到out中
        try {
            template.process(map, out); // 往模板里写数据
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        TemplateUtil hf = new TemplateUtil();
        hf.process();
    }
}
