package xyz.blackmoster.spring5webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.blackmoster.spring5webapp.repositories.CompanyRepository;

@Controller
public class CompaniesController {
	
	private CompanyRepository companyRepository;

	@Autowired
	public CompaniesController(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	@RequestMapping("/companies")
	public String getCompanies(Model model) {
		
		model.addAttribute("companies", companyRepository.findAll());
		
		return "companies";
	}
}
