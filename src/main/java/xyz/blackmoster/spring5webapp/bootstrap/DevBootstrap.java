package xyz.blackmoster.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import xyz.blackmoster.spring5webapp.model.Company;
import xyz.blackmoster.spring5webapp.model.WorkExperience;
import xyz.blackmoster.spring5webapp.repositories.CompanyRepository;
import xyz.blackmoster.spring5webapp.repositories.WorkExperienceRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private CompanyRepository companyRepository;
	
	private WorkExperienceRepository workExperienceRepository;

	@Autowired
	public DevBootstrap(CompanyRepository companyRepository, WorkExperienceRepository workExperienceRepository) {
		this.companyRepository = companyRepository;
		this.workExperienceRepository = workExperienceRepository;
	}

	private void initData() {
		
		Company company1 = new Company();
		company1.setName("Comtrade");
		company1.setLink("https://www.comtrade.com/");
		companyRepository.save(company1);
		
		WorkExperience experience1 = new WorkExperience();
		experience1.setCompany(company1);
		experience1.setTitle("Junior Software Developer");
		experience1.setDescription("Developing game platform");
		workExperienceRepository.save(experience1);

		Company company2 = new Company();
		company2.setName("XLAB");
		company2.setLink("https://www.xlab.si/");
		companyRepository.save(company2);
		
		WorkExperience experience2 = new WorkExperience();
		experience2.setCompany(company2);
		experience2.setTitle("Software Developer");
		experience2.setDescription("Developing software support solutions");
		workExperienceRepository.save(experience2);
		
		Company company3 = new Company();
		company3.setName("SHS Viveon");
		company3.setLink("https://www.shs-viveon.com");
		companyRepository.save(company3);
		
		WorkExperience experience3 = new WorkExperience();
		experience3.setCompany(company3);
		experience3.setTitle("Software Developer");
		experience3.setDescription("Developing risk management suite");
		workExperienceRepository.save(experience3);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
}
