package cn.cgy.utils;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
	
	public static void write(HttpServletResponse response,Object o){
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.println(o.toString());
			out.flush();
			out.close();
		}

	}

	public static void write(HttpServletResponse response,JSONObject jsonObject){
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-store");
		JSONObject object = jsonObject;
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(object.toString());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
				object = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
