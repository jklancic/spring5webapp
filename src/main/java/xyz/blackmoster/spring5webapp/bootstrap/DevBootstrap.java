package xyz.blackmoster.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import xyz.blackmoster.spring5webapp.model.Address;
import xyz.blackmoster.spring5webapp.model.Company;
import xyz.blackmoster.spring5webapp.model.WorkExperience;
import xyz.blackmoster.spring5webapp.repositories.AddressRepository;
import xyz.blackmoster.spring5webapp.repositories.CompanyRepository;
import xyz.blackmoster.spring5webapp.repositories.WorkExperienceRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private CompanyRepository companyRepository;
	
	private WorkExperienceRepository workExperienceRepository;
	
	private AddressRepository addressRepository;

	@Autowired
	public DevBootstrap(
		CompanyRepository companyRepository,
		WorkExperienceRepository workExperienceRepository,
		AddressRepository addressRepository) {
		this.companyRepository = companyRepository;
		this.workExperienceRepository = workExperienceRepository;
		this.addressRepository = addressRepository;
	}

	private void initData() {

		Address address1 = new Address();
		address1.setCity("Maribor");
		address1.setCountry("Slovenia");
		address1.setPostalCode("2000");
		address1.setStreet("Ob Dravi 6");
		addressRepository.save(address1);
		
		Company company1 = new Company();
		company1.setName("Comtrade");
		company1.setLink("https://www.comtrade.com/");
		company1.setAddress(address1);
		companyRepository.save(company1);
		
		WorkExperience experience1 = new WorkExperience();
		experience1.setCompany(company1);
		experience1.setTitle("Junior Software Developer");
		experience1.setDescription("Developing game platform");
		workExperienceRepository.save(experience1);

		Address address2 = new Address();
		address2.setCity("Ljubljana");
		address2.setCountry("Slovenia");
		address2.setPostalCode("1000");
		address2.setStreet("Potza Brdom 100");
		addressRepository.save(address2);
		
		Company company2 = new Company();
		company2.setName("XLAB");
		company2.setLink("https://www.xlab.si/");
		company2.setAddress(address2);
		companyRepository.save(company2);
		
		WorkExperience experience2 = new WorkExperience();
		experience2.setCompany(company2);
		experience2.setTitle("Software Developer");
		experience2.setDescription("Developing software support solutions");
		workExperienceRepository.save(experience2);

		Address address3 = new Address();
		address3.setCity("Munich");
		address3.setCountry("Germany");
		address3.setPostalCode("81249");
		address3.setStreet("Clarita-Bernhard-Straße 27");
		addressRepository.save(address3);
		
		Company company3 = new Company();
		company3.setName("SHS Viveon");
		company3.setLink("https://www.shs-viveon.com");
		company3.setAddress(address3);
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
