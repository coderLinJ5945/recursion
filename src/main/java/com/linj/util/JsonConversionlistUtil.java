package com.linj.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.linj.pojo.TreeView;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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

    /**
     * 后台查询数据转成前台的复杂json树
     */
    /*private static JSONObject JsimpleListToJson(List<?> list){

        return null;
    }*/
    public static JSONArray simpleListToJson(List<TreeView> menuList){
        JSONObject jsonObject = new JSONObject();
        List<TreeView> nodeList = new ArrayList<>();
        //todo : 这里的循环不是二次方，而且可用通过数据排序进行优化，肯定可以减少循环比对的次数
        for (TreeView node1 : menuList) {
            boolean mark = false;
            for (TreeView node2 : menuList) {
                //如果node1的节点不为空 并且 node1节点的父id = node2的节点id
                if (node1.getParentId() != null && node1.getParentId().equals(node2.getId())) {
                    //判断成功，就说明node1和node2节点是父子关系： node2：父   node1：子
                    mark = true;//匹配成功，开关打开
                    //如果node2父节点 的子节点为空，就证明nede2节点没有其他的子节点数据，执行在node2的节点的children字段添加node1
                    if (node2.getChildren() == null) node2.setChildren(new ArrayList<TreeView>());
                    node2.getChildren().add(node1);
                    break;
                }
            }
            if (!mark) {
                nodeList.add(node1);
            }
        }
        JSONArray jsonArray = JSONArray.fromObject(nodeList);

        return jsonArray;
    }


}
