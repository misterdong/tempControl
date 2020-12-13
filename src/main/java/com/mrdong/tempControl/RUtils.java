package com.mrdong.tempControl;



import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class RUtils extends HashMap<String,Object> {
    private static final long serialVersionUID = 1L;

    public RUtils(){
        put("code",200);
        put("msg","success");
    }

    public static RUtils error(HttpStatus code, String msg){
        RUtils r = new RUtils();
        r.put("code",code);
        r.put("msg",msg);
        return r;
    }

    public static RUtils error(int code,String msg,String data){
        RUtils r = new RUtils();
        r.put("code",code);
        r.put("msg",msg);
        r.put("data",data);
        return r;
    }

    public static RUtils ok(String msg){
        RUtils r = new RUtils();
        r.put("msg",msg);
        return r;
    }

    public static RUtils ok(Map<String,Object> map){
        RUtils r = new RUtils();
        r.putAll(map);
        return r;
    }

    public static RUtils error(){
        return error(HttpStatus.INTERNAL_SERVER_ERROR,"未知异常");
    }

    public static RUtils error(String msg){
        return error(HttpStatus.INTERNAL_SERVER_ERROR,msg);
    }
}