package com.qr.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.qr.Entity.Complaint;
import com.qr.Repo.ComplaintRepo;

@RestController
public class MyController {
	
	@Autowired
	ComplaintRepo complaintRepo;

	@GetMapping("/test")
	public String test()
	{
		return "test";
		
	}
	
	
	
	@GetMapping("/getForm")
	public ModelAndView getForm()
	{
		ModelAndView obj=new ModelAndView();
		Complaint complaint=new Complaint();
		obj.addObject("complaint",complaint);
		obj.setViewName("form");
		return obj;
		
	}
	
	@PostMapping("/add")
	public ModelAndView  addComplaint(@ModelAttribute("complaint") Complaint complaint)
	{ 
	ModelAndView obj=new ModelAndView("success");	
	
	complaint.setId(UUID.randomUUID().toString());
	Complaint c=complaintRepo.save(complaint);
	obj.addObject("complaint", c);
	return obj;
	
	}
	
	@GetMapping("/view")
	public ModelAndView viewAll()
	{
		ModelAndView mav=new ModelAndView("view");
	List<Complaint> complaints=	complaintRepo.findAll();
	mav.addObject("complaints", complaints);
	return mav;
	}
	
	
}
