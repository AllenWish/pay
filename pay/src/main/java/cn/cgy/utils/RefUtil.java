package cn.cgy.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by allenwish on 2017-11-16.
 */
public class RefUtil {

	public static final String TOTAL = "total";
	public static final String ROWS = "rows";

    /**
     * map转实体类
     * @param bean
     * @param map
     * @param <T>
     */
	@SuppressWarnings("hiding")
	public static <T> void map2bean(T bean,Map<String,Object> map){
	    //BeanUtils.populate(obj, map);
		Class<? extends Object> beanClass = bean.getClass();
		// 查找set方法
		Field[] fields = beanClass.getDeclaredFields();
		for(Field f:fields){
			String fieldName = f.getName();
			if(map.get(fieldName)!=null){
				Object fileValue = map.get(fieldName);

				//String setFieldName =getSetterMethodName(fieldName);// 获取set方法名
				String setFieldName =methodName(fieldName, GETSET.SET);
				//String getFieldName =getGetterMethodName(fieldName);// 获得get方法名
				String getFieldName =methodName(fieldName, GETSET.GET);
				Method getMethod;
				try {
					getMethod = beanClass.getMethod(getFieldName);// 获取获取方法

					Class<?> propertyType = getMethod.getReturnType();// 获取属性类型
					Method setMethod = beanClass.getMethod(setFieldName,
							new Class[] { propertyType });
					Object value = ConvertHandler(propertyType, fileValue);// 获得新值value
					setMethod.invoke(bean, new Object[] { value });
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
					continue;
				} catch (SecurityException e) {
					e.printStackTrace();
					continue;
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					continue;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					continue;
				} catch (InvocationTargetException e) {
					e.printStackTrace();
					continue;
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}

		}
	}

    /**
     * 类型转换器
     * @param type
     * @param filevalue
     * @return
     * @throws Exception
     */
	private static Object ConvertHandler(Class<?> type, Object filevalue)
			throws Exception {
		String typename = type.getName();
		if (filevalue.getClass().getName().equals(typename))
			return filevalue;// 与所给类型值相同
		else if ("Boolean".equalsIgnoreCase(typename)
				|| "java.lang.Boolean".equals(typename)) {
			// boolean型
			if (filevalue.toString().equalsIgnoreCase("true") || filevalue.equals("1"))
				return new Boolean(true);
			else
				return new Boolean(false);
		} else if ("int".equalsIgnoreCase(typename)
				|| "Integer".equals(typename)
				|| "java.lang.Integer".equals(typename))
			return Integer.valueOf(filevalue.toString());// int 型
		else if ("String".equalsIgnoreCase(typename)
				|| "java.lang.String".equals(typename))
			return filevalue.toString();// String 型
		else if("java.util.Date".equalsIgnoreCase(typename)){
			return (Date)filevalue;
		} else {
			throw new Exception("不支持"+typename+"此类型赋值");
		}
	}

    /**
     * 实体类转map
     * @param bean
     * @param <T>
     * @return
     */
	public static <T> Map bean2map(T bean){
		Map<String,Object> map = new HashMap<String,Object>();
		bean2map(bean,map);
		return map;
	}

    /**
     * 对象值放入map
     * @param bean
     * @param map
     * @param <T>
     */
	public static <T> void bean2map(T bean,Map<String,Object> map){
		if(map==null){
			map = new HashMap<String,Object>();
		}
		Class<? extends Object> beanClass = bean.getClass();
		// 查找set方法
		Field[] fields = beanClass.getDeclaredFields();
		for(Field f:fields){
			String fieldName = f.getName();
			//Method getMethod=ReflectionUtils.findMethod(beanClass,methodName(fieldName,GETSET.GET));
			try {
				Method method = beanClass.getMethod(methodName(fieldName, GETSET.GET));
				map.put(fieldName,method.invoke(bean));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				continue;
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				continue;
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				continue;
			}
		}
	}
	/**
	 * 根据属性名称和java类型，获取对应的getter方法名
	 * @param property
	 * @return
	 */
	private static String getGetterMethodName(String property) {
		StringBuilder sb = new StringBuilder();
		sb.append(property);
		if (Character.isLowerCase(sb.charAt(0))) {
			if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
				sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
			}
		}
		sb.insert(0, "get");
		return sb.toString();
	}
	/**
	 * 根据属性名称获取对应的setter方法名称
	 * @param property
	 * @return
	 */
	private static String getSetterMethodName(String property) {
		StringBuilder sb = new StringBuilder();
		sb.append(property);
		if (Character.isLowerCase(sb.charAt(0))) {
			if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
				sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
			}
		}
		sb.insert(0, "set");
		return sb.toString();
	}


	/**
	 * 根据属性名称获取和get/set获取该属性的get/set方法名称
	 * @param property
	 * @param type
	 * @return
	 */
	public static String methodName(String property,GETSET type){
		StringBuilder sb = new StringBuilder();
		sb.append(property);
		if (Character.isLowerCase(sb.charAt(0))) {
			if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
				sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
			}
		}
		sb.insert(0, type.getName());
		return sb.toString();
	}

	public enum GETSET{
		GET("get"),SET("set");
		private String name;
		GETSET(String name){
			this.name = name;
		}
		public String getName(){
			return this.name;
		}
	}

	public enum MAPNUL{
	    MNVL(""),CHILD("child");
	    private String name;
        MAPNUL(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
    }


    /**
     * json转成map
     * @param json
     * @param map
     * @param keyn
     * @return
     */
	public static Map<String,Object> JSON2map(JSONObject json,Map<String,Object> map,String keyn){
        Iterator iterator = json.keys();
        String key;
        Object value;
        while(iterator.hasNext()){
            key = iterator.next().toString();
            value = json.get(key);
            //System.out.println("json key:value="+key+":"+value);
            map = getMapVal(key,value,map,keyn);
        }
	    return map;
    }


    /**
     * 把json的值并封装到map中
     * @param key
     * @param value
     * @param map
     * @param keyn
     * @return
     */
    private static Map<String,Object> getMapVal(String key,Object value,Map<String,Object> map,String keyn){
	    if(value instanceof JSONObject){
            map = JSON2map(JSONObject.fromObject(value),map,keyn.equals("")?key:keyn+"."+key);
        }else{
	        map.put(keyn.equals(MAPNUL.MNVL.getName())?key:keyn+"."+key,value);
           // System.out.println("Map  key:value="+key+":"+value);
        }
	    return map;
    }


    /**
     * map转换成json
     * @param map
     * @param flag
     * @return
     */
    public static JSONObject map2JSON(Map<String,Object> map,MAPNUL flag){
        JSONObject json = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if(flag.getName().equals(MAPNUL.CHILD.getName())){
                json = getJSONVal(entry.getKey(),entry.getValue(),json);
            }else{
                json.put(entry.getKey(),entry.getValue());
            }

        }
        return json;
    }


    /**
     * 把map中的值放入json
     * @param key
     * @param value
     * @param json
     * @return
     */
	private static JSONObject getJSONVal(String key,Object value,JSONObject json){
        if(key.indexOf(".")>=0){
            String[] keys = key.split("\\.",2);
            if(json.has(keys[0])){
                //already put this key
                json.put(keys[0],getJSONVal(keys[1],value,json.getJSONObject(keys[0])));
            }else{
                //no this key
                json.put(keys[0],getJSONVal(keys[1],value,new JSONObject()));
            }
        }else{
            json.put(key,value);
        }
        return json;
    }



    public static JSONObject listMap2JSONObject(List<Map<String,Object>> listmap,JSONObject json,String totSize,String rows){
        JSONArray array = new JSONArray();
	    for(Map<String,Object> map:listmap){
            array.add(map2JSON(map, MAPNUL.MNVL));
        }
        json.put(totSize,listmap.size());
        json.put(rows,array);
	    return json;
    }





    public static void main(String[] args) {
		/*Student student = new Student();
		System.out.println(student);
		Map<String,Object> stuMap = new HashMap<String, Object>();
		stuMap.put("name", "allen");
		stuMap.put("age", 25);
		RefUtil.map2bean(student, stuMap);
		System.out.println(student);
		stuMap.put("nickName", "wish");
		stuMap.put("birth", new Date());
		RefUtil.map2bean(student, stuMap);
		System.out.println(student);

		stuMap.put("isVIP", true);
		RefUtil.map2bean(student, stuMap);
		System.out.println(student);
		Map<String,Object> map = new HashMap<>();
		map.put("flag","1");
		RefUtil.bean2map(student,map);
		System.out.println(map);
		Student stu = new Student();
		RefUtil.map2bean(stu, map);
		System.out.println(stu);*/
        Map map = new HashMap();
        map.put("msg", "yes");//map里面装有yes
        map.put("user.id", 123);
        map.put("user.name", "allen.wish");
        map.put("user.lname.first", "allen");
        map.put("user.lname.reaname", "wish");
        JSONObject jsonObject = map2JSON(map, MAPNUL.MNVL);
        System.out.println("map:"+map);
        System.out.println("输出的结果是：" + jsonObject);
        map.clear();
        map = JSON2map(jsonObject,map, MAPNUL.MNVL.getName());
        System.out.println("json转换map:"+map);

        List<Map<String,Object>> listmap = new ArrayList<>();
        listmap.add(map);
        map.put("user.id",234);
        listmap.add(map);
        map.put("user.id",456);
        listmap.add(map);

        jsonObject = new JSONObject();
        jsonObject = listMap2JSONObject(listmap,jsonObject,TOTAL,ROWS);
        System.out.println(jsonObject.toString());
    }
}
