package com.ra.controller;

import com.ra.model.entity.NhanVien.NhanVien;
import com.ra.model.entity.PhongBan.PhongBan;
import com.ra.model.service.NhanVien.EmployeeService;
import com.ra.model.service.PhongBan.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Controller
@RequestMapping("/NhanVien")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @GetMapping
    public String index(Model model) {
        List<NhanVien> nhanVien = employeeService.findAll();
        model.addAttribute("nhanVien", nhanVien);
        return "NhanVien/index";
    }
    @GetMapping("/add")
    public String add(Model model) {
        NhanVien nhanVien = new NhanVien();
        model.addAttribute("nhanVien", nhanVien);
        List<PhongBan> phongBanList = departmentService.findAll();
        model.addAttribute("phongBanList", phongBanList);
        return "NhanVien/add";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute NhanVien nhanVien, @RequestParam("imgFile")MultipartFile file) {
        // Xử lí up ảnh
        String fileName = file.getOriginalFilename();
        String path = "D:\\HN-PTHB-JV240603\\MD3\\demo\\demo\\src\\main\\webapp\\uploads";
        File destination = new File(path+"/"+fileName);
        try {
            Files.write(destination.toPath(), file.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        nhanVien.setImages(fileName);
        if(employeeService.add(nhanVien)) {
            return "redirect:/NhanVien";
        }
        return "redirect:/NhanVien/index";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable("id") int id) {
        NhanVien nhanVien = employeeService.findById(id);
        model.addAttribute("nhanVien", nhanVien);
        List<PhongBan> phongBanList = departmentService.findAll();
        model.addAttribute("phongBanList", phongBanList);
        return "NhanVien/edit";
    }
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute NhanVien nhanVien, @PathVariable("id") int id, @RequestParam("imgFile") MultipartFile file) {
        if(!file.isEmpty()) {
            // Xử lí up ảnh
            String fileName = file.getOriginalFilename();
            String path = "D:\\HN-PTHB-JV240603\\MD3\\demo\\demo\\src\\main\\webapp\\uploads";
            File destination = new File(path+"/"+fileName);
            try {
                Files.write(destination.toPath(), file.getBytes(), StandardOpenOption.CREATE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(employeeService.update(nhanVien)) {
            return "redirect:/NhanVien";
        }
        return "redirect:/NhanVien/index" + nhanVien.getId();
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        if(employeeService.delete(id)) {
            return "redirect:/NhanVien";
        }
        return "redirect:/NhanVien/index" + id;
    }
}
