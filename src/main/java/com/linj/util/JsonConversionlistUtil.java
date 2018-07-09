package com.linj.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.linj.pojo.TreeView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 使用jackon工具包
 * 用于前端的树结构和后台数据格式的互转工具类
 */
public final class JsonConversionlistUtil{

    /**
     *
     * @param jsonStr  json树的字符串
     * @param pojo 需要转换的实体类class
     * @param <E>
     * @return  返回一个和json树格式一样的 list 集合(保留树结构的list)
     * @throws IOException
     */
    public static <E> List<E> jsonStrToListTreeView(final String jsonStr, final Class<E> pojo) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class,pojo);
        // TODO: 2018/7/9  这里需要研究一下 readValue的源码，来实现泛型的转换问题
        List<E> configList =  mapper.readValue(jsonStr, javaType);   //这里不需要强制转换
        return configList;
    }


    /**
     * 将json树格式的List转换成简单的单层list格式数据
     * （用于存储入库的格式）
     *
     * @param complexList 和json树格式一样复杂的 List集合
     * @return 返回单层list格式数据
     */
    public static  List<TreeView> complexToSimpleList(List<TreeView>complexList){
        List<TreeView> simpleList = new ArrayList<>();
        recursionList(complexList,simpleList);
        return simpleList;
    }

    /**
     * 递归
     * @param complexList
     * @param simpleList
     */
    private static  void recursionList(List<TreeView> complexList, List<TreeView> simpleList){
        Iterator<TreeView> it = complexList.iterator();
        while(it.hasNext()){
            TreeView obj = it.next();
            simpleList.add(obj);
            if(obj.getChildren() != null){
                recursionList(obj.getChildren(),simpleList);
            }
        }
    }




}
