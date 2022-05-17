package com.example.SpringProject.controller;

import com.example.SpringProject.entity.Hotels;
import com.example.SpringProject.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelRepository eRepo;

    @GetMapping({"/hotels"})
    public ModelAndView getAllHotels() {
        ModelAndView mav = new ModelAndView("hotels");
        mav.addObject("hotels", eRepo.findAll());
        return mav;
    }

    @GetMapping({"/admin/list-hotels"})
    public String listHotels(Model model) {
        List<Hotels> listHotels = eRepo.findAll();
        model.addAttribute("listHotels", listHotels);

        return "admin/list-hotels";
    }

    @GetMapping(value = "/admin/hotel-form")
    public ModelAndView addHotelForm() {
        ModelAndView mav = new ModelAndView("admin/hotel-form");
        Hotels hotels = new Hotels();
        mav.addObject("hotels", hotels);
        return mav;
    }

    @PostMapping("/admin/saveHotels")
    public String saveHotels(Hotels hotels, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/hotel-form";
        }
        eRepo.save(hotels);
        return "redirect:/admin/list-hotels";
    }

    @GetMapping("/admin/roomUpdateForm")
    public ModelAndView roomUpdateForm(@RequestParam Long hotelsId) {
        ModelAndView mav = new ModelAndView("hotel-form");
        Hotels hotels = eRepo.findById(hotelsId).get();
        mav.addObject("hotels", hotels);
        return mav;
    }

    @GetMapping("/admin/deleteHotels")
    public String deleteHotels(@RequestParam Long hotelsId) {
        eRepo.deleteById(hotelsId);
        return "redirect:/admin/hotels";
    }

}
