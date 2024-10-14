package com.ra.controller;

import com.ra.model.entity.PhongBan.PhongBan;
import com.ra.model.service.PhongBan.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/PhongBan")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping
    public String index(Model model) {
        List<PhongBan> phongBanList = departmentService.findAll();
        model.addAttribute("phongBanList", phongBanList);
        return "PhongBan/index";
    }
    @GetMapping("/add")
    public String add(Model model) {
        PhongBan phongBan = new PhongBan();
        model.addAttribute("phongBan", phongBan);
        return "PhongBan/add";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute PhongBan phongBan) {
        if(departmentService.add(phongBan)) {
            return "redirect:/PhongBan";
        }
        return "PhongBan/add";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        PhongBan phongBan = departmentService.findById(id);
        model.addAttribute("phongBan", phongBan);
        return "PhongBan/edit";
    }
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("phongBan") PhongBan phongBan, @PathVariable("id") Integer id) {
        if(departmentService.update(phongBan)) {
            return "redirect:/PhongBan";
        }
        return "PhongBan/edit";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        departmentService.delete(id);
        return "redirect:/PhongBan";
    }
}
