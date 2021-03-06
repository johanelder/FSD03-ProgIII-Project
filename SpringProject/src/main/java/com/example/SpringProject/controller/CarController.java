package com.example.SpringProject.controller;


import com.example.SpringProject.entity.BookingCar;
import com.example.SpringProject.entity.Cars;
import com.example.SpringProject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarRepository eRepo;

    @GetMapping({"/cars"})
    public ModelAndView getAllCars() {
        ModelAndView mav = new ModelAndView("cars");
        mav.addObject("cars", eRepo.findAll());
        return mav;
    }


    @RequestMapping({"/admin/cars", "/booking-cars"})
    public String listCars(Model model) {
        List<Cars> listCars = eRepo.findAll();
        model.addAttribute("listCars", listCars);

        return "admin/list-cars";
    }
/*
    @RequestMapping({"/booking-cars"})
    public String listBookingCar(Model model) {
        List<Cars> listBookingCar = eRepo.findAll();
        model.addAttribute("BookingCars", listBookingCar);

        return "booking-cars";
    }
*/
    @GetMapping(value = "/admin/car-form")
    public ModelAndView addCarForm() {
        ModelAndView mav = new ModelAndView("admin/car-form");
        Cars cars = new Cars();
        mav.addObject("cars", cars);
        return mav;
    }

    @PostMapping("/admin/saveCars")
    public String saveCars(Cars cars, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/car-form";
        }
        eRepo.save(cars);
        return "redirect:/admin/cars";
    }

    @GetMapping("/admin/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long carsId) {
        ModelAndView mav = new ModelAndView("admin/car-form");
        Cars cars = eRepo.findById(carsId).get();
        mav.addObject("cars", cars);
        return mav;
    }

    @GetMapping("/admin/deleteCars")
    public String deleteCars(@RequestParam Long carsId) {
        eRepo.deleteById(carsId);
        return "redirect:/admin/cars";
    }



} // end controller class CarController
