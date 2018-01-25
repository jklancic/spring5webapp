package xyz.blackmoster.spring5webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.blackmoster.spring5webapp.repositories.AddressRepository;

@Controller
public class AddressController {
	
	private AddressRepository addressRepository;

	@Autowired
	public AddressController(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@RequestMapping("/addresses")
	public String getAddresses(Model model) {
		model.addAttribute("addresses", addressRepository.findAll());
		return "addresses";
	}
}
