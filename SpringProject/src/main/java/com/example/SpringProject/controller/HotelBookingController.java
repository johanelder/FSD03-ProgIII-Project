package com.example.SpringProject.controller;

import com.example.SpringProject.entity.Cars;
import com.example.SpringProject.entity.Room;

import com.example.SpringProject.entity.RoomBooking;

import com.example.SpringProject.entity.User;
import com.example.SpringProject.repository.RoomBookingRepository;
import com.example.SpringProject.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Controller
public class HotelBookingController {

    @Autowired
    private RoomRepository roomRepo;
    @Autowired
    private RoomBookingRepository roomBookingRepo;

    @GetMapping("/hotelSearch")
    public String hotelSearch() {

        return "hotelSearch";
    }

    // This method is used to search for hotels
    @GetMapping ("/searchHotel")
    public ModelAndView roomHotel(@RequestParam String city, @RequestParam String checkIn, @RequestParam String checkOut, @RequestParam int quantity) throws ParseException {
        ModelAndView mav = new ModelAndView("listRooms");
        List<Room> rooms = roomRepo.findByCity(city);
        System.out.println(checkIn + " " + checkOut);
        SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dates.parse(checkIn);
        Date date2 = dates.parse(checkOut);
        long stayDays = ChronoUnit.DAYS.between(date1.toInstant(), date2.toInstant());

        System.out.println(stayDays);
        mav.addObject("stayDays", stayDays);
        mav.addObject("rooms", rooms);
        mav.addObject("city", city);
        mav.addObject("checkIn", checkIn);
        mav.addObject("checkOut", checkOut);
        mav.addObject( "quantity", quantity);

        return mav;
    }
 // This method is used to book a room
    @GetMapping("/bookRoom")
    public String bookRoom(@RequestParam Long roomId, @RequestParam Long stayDays ,  @RequestParam String checkOut , @RequestParam String checkIn, @RequestParam int quantity, Model model) {
        Room room = roomRepo.findById(roomId).get();
        double totalPrice = stayDays * room.getPrice();
        model.addAttribute("room", room);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("stayDays", stayDays);
        model.addAttribute("checkIn", checkIn);
        model.addAttribute("checkOut", checkOut);
        model.addAttribute( "quantity", quantity);
        return "bookRoom";
    }

    @PostMapping("/saveRoomBooking")
    public String saveRoomBooking(@Valid RoomBooking roomBooking, Errors errors) {
        if (errors.hasErrors()) {
            return "bookRoom";
        }else {
        roomBooking.setPaymentStatus("Pending");
            roomBookingRepo.save(roomBooking);
       return "roomBookingSuccess";
    }
}

@GetMapping("/userRoomBookings")
public ModelAndView userRoomBookings(@RequestParam Long userId ) {
    ModelAndView mav = new ModelAndView("userRoomBookings");
    List<RoomBooking> roomBookings = roomBookingRepo.findByUserId(userId);
    mav.addObject("roomBookings", roomBookings);

    return mav;
}

@GetMapping("/deleteBooking")
public String deleteBooking(@RequestParam Long bookingId, @RequestParam Long userId) {
    roomBookingRepo.deleteById(bookingId);
    //return "redirect to userRoomBookings with param userId
    return "redirect:/userRoomBookings?userId="+ userId;
}

    @GetMapping("admin/rooms")
    public String listRooms(Model model) {
        List<Room> listRooms = roomRepo.findAll();
        model.addAttribute("listRooms", listRooms);

        return "admin/rooms";
    }

    @PostMapping("/admin/saveRoom")
    public String saveRoom(@Valid Room room, Errors errors) {
        // validation
        if (null != errors && errors.getErrorCount() > 0) {
            return "/admin/roomUpdateForm";
        } else {
            roomRepo.save(room);
            return "redirect:/admin/rooms";
        }
    }

    // Delete User
    @GetMapping("admin/deleteRoom")
    public String deleteRoom(@RequestParam Long roomId){
        roomRepo.deleteById(roomId);
        return "redirect:/admin/rooms";
    }

    @GetMapping("/admin/addRoom")
    public ModelAndView addCarForm() {
        ModelAndView mav = new ModelAndView("admin/addRoom");
        Room room = new Room();
        mav.addObject("room", room);
        return mav;
    }

}

