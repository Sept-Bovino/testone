package com.allinpay.quickpay.demo.utils;

import com.allinpay.quickpay.demo.entity.CommonParam;
import com.sun.source.tree.Tree;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import javax.swing.text.html.parser.Entity;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 */
public class FormatTransferUtils {

    /**
     *
     */
//    public static Map<String, Object> requestParam2Map(RequestParam requestParam) {
//
//    }

    /**
     *
     */
    public static <T> T entity2Object(CommonParam commonParam, Class<T> clz) {
        JSONObject json = JSONObject.fromObject(commonParam);
        T obj = (T) JSONObject.toBean(json, clz);
        return obj;
    }

    public static Map<String, String> entity2Map(CommonParam commonParam){
        return entity2Object(commonParam, Map.class);
    }

    public static TreeMap<String, String> entity2TreeMap(CommonParam commonParam){
        return entity2Object(commonParam, TreeMap.class);
    }
}
