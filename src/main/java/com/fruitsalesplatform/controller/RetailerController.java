package com.fruitsalesplatform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fruitsalesplatform.entity.Retailer;
import com.fruitsalesplatform.service.RetailerService;

@Controller
public class RetailerController extends BaseController {

    @Resource
    RetailerService retailerService;

    @RequestMapping("/retailer/queryEditRetailer.action")
    public @ResponseBody
    Retailer queryEditRetailer(@RequestBody
    String id) {

        //因为传过来的json是一个对象
        String idString = JSONObject.parseObject(id).getString(id);

        return retailerService.get(idString);
    }

    @RequestMapping("/retailer/list.action")
    public String list(Model model, Retailer retailer, String startTime,
        String endTime) {

        Map<String, Object> map = this.retailerToMap(retailer);

        if (startTime != null && !"".equals(startTime)) {
            map.put("startTime", startTime);
        }

        if (endTime != null && !"".equals(endTime)) {
            map.put("endTime", endTime);
        }

        List<Retailer> retailersList = retailerService.find(map);

        model.addAttribute("list", retailersList);

        //当前页数
        model.addAttribute("currentPage", retailer.getCurrentPage());

        //当前请求页数，默认为0
        model.addAttribute("startPage", retailer.getStartPage());

        int countNumber = retailerService.count(map);

        //数据总和
        model.addAttribute("countNumber", countNumber);

        int pageSize = retailer.getPageSize();

        //每页数据，默认为10
        model.addAttribute("pageSize", pageSize);

        //总页数
        int sumPageNumber =
            countNumber % pageSize == 0
                ? (countNumber / pageSize)
                : ((countNumber / pageSize) + 1);

        model.addAttribute("sumPageNumber", sumPageNumber);

        return "/retailer/retailerHome.jsp";
    }

    private Map<String, Object> retailerToMap(Retailer retailer) {
        // TODO Auto-generated method stub

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", checkStringIsEmpty(retailer.getName()));

        map.put("telephone", checkStringIsEmpty(retailer.getTelephone()));

        map.put("address", checkStringIsEmpty(retailer.getAddress()));

        map.put("status",
            retailer.getStatus() == -1 ? null : retailer.getStatus());

        map.put("createTime", checkStringIsEmpty(retailer.getCreateTime()));

        map.put("startPage", retailer.getStartPage());

        map.put("pageSize", retailer.getPageSize());

        return map;
    }

    private String checkStringIsEmpty(String param) {
        // TODO Auto-generated method stub
        // 三元运算符 表达式？true：flase
        return param == null ? null : (param.equals("") ? null : "%" + param
            + "%");
    }

}
