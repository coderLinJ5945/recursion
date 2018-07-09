import com.google.common.collect.Lists;
import com.linj.pojo.TreeView;
import com.linj.util.JsonConversionlistUtil;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        List<TreeView> list2 = Lists.newArrayList();


        String jsonStr ="[{\n" + "        \"id\": \"402880636463f4e3016463f4e3e60000\",\n" + "        \"name\": \"首页\",\n" + "        \"checked\": false,\n" + "        \"state\": null,\n" + "        \"children\": null,\n" + "        \"url\": \"/dashboard/home\",\n" + "        \"icon\": \"icon-home\",\n" + "        \"parentId\": \"0\",\n" + "        \"hasParent\": false,\n" + "        \"hasChildren\": false\n" + "   }, {\n" + "        \"id\": \"402880636463f4e3016463f4e3e60001\",\n" + "        \"name\": \"门店管理\",\n" + "        \"checked\": false,\n" + "        \"state\": null,\n" + "        \"children\": null,\n" + "        \"url\": \"/dashboard/shop\",\n" + "        \"icon\": \"icon-settings\",\n" + "        \"parentId\": \"0\",\n" + "        \"hasParent\": false,\n" + "        \"hasChildren\": false\n" + "   }, {\n" + "        \"id\": \"402880636463f4e3016463f4e3e60002\",\n" + "        \"name\": \"店铺管理\",\n" + "        \"checked\": false,\n" + "        \"state\": null,\n" + "        \"children\": [{\n" + "                \"id\": \"402880636463f4e3016463f4e3e60003\",\n" + "                \"name\": \"账号列表\",\n" + "                \"checked\": false,\n" + "                \"state\": null,\n" + "                \"children\": [{\n" + "                        \"id\": \"402880636463f4e3016463f4e3e60004\",\n" + "                        \"name\": \"hhhh\",\n" + "                        \"checked\": false,\n" + "                        \"state\": null,\n" + "                        \"children\": null,\n" + "                        \"url\": \"/dashboard/merchant/account\",\n" + "                        \"icon\": null,\n" + "                        \"parentId\": \"402880636463f4e3016463f4e3e60002\",\n" + "                        \"hasParent\": true,\n" + "                        \"hasChildren\": false\n" + "     }, {\n" + "                        \"id\": \"402880636463f4e3016463f4e3e60008\",\n" + "                        \"name\": \"hhhh\",\n" + "                        \"checked\": false,\n" + "                        \"state\": null,\n" + "                        \"children\": null,\n" + "                        \"url\": \"/dashboard/merchant/account\",\n" + "                        \"icon\": null,\n" + "                        \"parentId\": \"402880636463f4e3016463f4e3e60002\",\n" + "                        \"hasParent\": true,\n" + "                        \"hasChildren\": false\n" + "     }],\n" + "                \"url\": \"/dashboard/merchant/account\",\n" + "                \"icon\": null,\n" + "                \"parentId\": \"402880636463f4e3016463f4e3e60002\",\n" + "                \"hasParent\": true,\n" + "                \"hasChildren\": false\n" + "    }],\n" + "        \"url\": \"\",\n" + "        \"icon\": \"icon-shop\",\n" + "        \"parentId\": \"0\",\n" + "        \"hasParent\": false,\n" + "        \"hasChildren\": true\n" + "   }, {\n" + "        \"id\": \"402880636463f4e3016463f4e3e60005\",\n" + "        \"name\": \"AAA\",\n" + "        \"checked\": false,\n" + "        \"state\": null,\n" + "        \"children\": null,\n" + "        \"url\": \"/dashboard/merchant/account\",\n" + "        \"icon\": null,\n" + "        \"parentId\": \"402880636463f4e3016463f4e3e60002\",\n" + "        \"hasParent\": true,\n" + "        \"hasChildren\": false\n" + "   }]";
        List<TreeView> list = JsonConversionlistUtil.jsonStrToListTreeView(jsonStr,TreeView.class);
        List<TreeView> simpleList = JsonConversionlistUtil.complexToSimpleList(list);
        System.out.println();
    }
}