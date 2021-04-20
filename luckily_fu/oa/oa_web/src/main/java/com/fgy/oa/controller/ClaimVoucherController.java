package com.fgy.oa.controller;

import com.fgy.oa.domain.*;
import com.fgy.oa.global.Constant;
import com.fgy.oa.service.ClaimVoucherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 报销单控制层
 */
@Controller
@RequestMapping("/claim_voucher")
@SessionAttributes(value = "employee", types = Employee.class)
public class ClaimVoucherController {
    @Resource(name = "claimVoucherService")
    private ClaimVoucherService claimVoucherService;

    /**
     * 跳转到添加报销单页面
     * @return
     */
    @RequestMapping("/to_add")
    public ModelAndView toAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items", Constant.getItems());
        modelAndView.setViewName("claim_voucher_add");
        return modelAndView;
    }

    /**
     * 添加报销单
     * @param map
     * @param info
     * @return
     */
    @RequestMapping("/add")
    public String add(ModelMap map, ClaimVoucherInfo info){
        Employee employee = (Employee) map.get("employee");
        info.getClaimVoucher().setCreate_sn(employee.getSn());
        claimVoucherService.save(info.getClaimVoucher(), info.getItems());
        return "redirect:/claim_voucher/detail/" + info.getClaimVoucher().getId();
    }

    /**
     * 查询报销单详情
     * @param id
     * @return
     */
    @RequestMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable(value = "id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("claimVoucher",claimVoucherService.get(id));
        modelAndView.addObject("items",claimVoucherService.getItems(id));
        modelAndView.addObject("records",claimVoucherService.getRecords(id));
        modelAndView.setViewName("claim_voucher_detail");
        return modelAndView;
    }

    /**
     * 查询个人报销单
     * @param modelMap
     * @return
     */
    @RequestMapping("/self")
    public String self(ModelMap modelMap){
        Employee employee = (Employee) modelMap.get("employee");
        modelMap.addAttribute("list",claimVoucherService.getForSelf(employee.getSn()));
        return "claim_voucher_self";
    }

    /**
     * 查询待处理报销单
     * @param modelMap
     * @return
     */
    @RequestMapping("/deal")
    public String deal(ModelMap modelMap){
        Employee employee = (Employee) modelMap.get("employee");
        modelMap.addAttribute("list", claimVoucherService.getForDeal(employee.getSn()));
        return "claim_voucher_deal";
    }

    /**
     * 跳转到报销单修改页面
     * @param id
     * @return
     */
    @RequestMapping("/to_update/{id}")
    public ModelAndView toUpdate(@PathVariable(value = "id") int id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("items", Constant.getItems());
        ClaimVoucherInfo info = new ClaimVoucherInfo();
        info.setClaimVoucher(claimVoucherService.get(id));
        info.setItems(claimVoucherService.getItems(id));
        mv.addObject("info",info);
        mv.setViewName("claim_voucher_update");
        return mv;
    }

    /**
     * 更新报销单信息
     * @param modelMap
     * @param info
     * @return
     */
    @RequestMapping("/update")
    public String update(ModelMap modelMap, ClaimVoucherInfo info){
        Employee employee = (Employee) modelMap.get("employee");
        info.getClaimVoucher().setCreate_sn(employee.getSn());
        claimVoucherService.update(info.getClaimVoucher(),info.getItems());
        return "redirect:/claim_voucher/deal";
    }

    /**
     * 提交报销单
     * @param id
     * @return
     */
    @RequestMapping("/submit/{id}")
    public String submit(@PathVariable(name = "id") int id){
        claimVoucherService.submit(id);
        return "redirect:/claim_voucher/deal";
    }

    /**
     * 跳转到处理报销单页面
     * @param id
     * @return
     */
    @RequestMapping("/to_check/{id}")
    public ModelAndView toCheck(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("claimVoucher",claimVoucherService.get(id));
        modelAndView.addObject("items",claimVoucherService.getItems(id));
        modelAndView.addObject("records",claimVoucherService.getRecords(id));
        DealRecord dealRecord =new DealRecord();
        dealRecord.setClaim_voucher_id(id);
        modelAndView.addObject("record",dealRecord);
        modelAndView.setViewName("claim_voucher_check");
        return modelAndView;
    }

    /**
     * 处理报销单（审核，打款）
     * @param map
     * @param dealRecord
     * @return
     */
    @RequestMapping("/check")
    public String check(ModelMap map, DealRecord dealRecord){
        Employee employee = (Employee)map.get("employee");
        dealRecord.setDeal_sn(employee.getSn());
        claimVoucherService.deal(dealRecord);
        return "redirect:/claim_voucher/deal";
    }
}
