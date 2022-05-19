package com.example.SpringProject.controller;


import com.example.SpringProject.entity.BookingCar;
import com.example.SpringProject.repository.BookingCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookingCarController {

    @Autowired
    private BookingCarRepository eRepo;

    @GetMapping({"/booking-cars-list"})
    public ModelAndView getAllBooking() {
        ModelAndView mav = new ModelAndView("booking-cars-list");
        mav.addObject("booking-cars-list", eRepo.findAll());
        return mav;
    }

   @GetMapping({"/admin/booking-cars"})
    public String listBookingCar(Model model) {
        List<BookingCar> listBookingCar = eRepo.findAll();
        model.addAttribute("BookingCars", listBookingCar);

        return "admin/booking-cars";
    }

    @GetMapping(value = "/booking-cars")
    public ModelAndView addBookingCarForm() {
        ModelAndView mav = new ModelAndView("/booking-cars");
        BookingCar bookingCar = new BookingCar();
        mav.addObject("booking-cars", bookingCar);
        return mav;
    }

    @PostMapping("/saveBooking-car")
    public String saveBookingCar(BookingCar booking, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/booking-cars";
        }
        eRepo.save(booking);
        return "redirect:/booking-cars";
    }

    @GetMapping("/bookingUpdateForm")
    public ModelAndView bookingUpdateForm(@RequestParam Long bookingId) {
        ModelAndView mav = new ModelAndView("/booking");
        BookingCar booking = eRepo.findById(bookingId).get();
        mav.addObject("booking", booking);
        return mav;
    }

    @GetMapping("/admin/deleteBooking")
    public String deleteBooking(@RequestParam Long bookingId) {
        eRepo.deleteById(bookingId);
        return "redirect:/admin/list-bookings";
    }
}
