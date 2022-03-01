package com.dfksoft.hrm_manage.data;

import com.dfksoft.hrm_manage.entity.Company;
import com.dfksoft.hrm_manage.repository.CompanyRepository;
import com.dfksoft.hrm_manage.service.AccountService;
import com.dfksoft.hrm_manage.service.LocationService;
import com.dfksoft.hrm_manage.service.RoleService;
import com.dfksoft.hrm_manage.service.TitleService;
import java.time.LocalTime;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitAppRunner implements ApplicationRunner {
    
    private final AccountService accountService;
    private final CompanyRepository companyRepository;
    private final RoleService roleService;
    private final LocationService locationService;
    private final TitleService titleService;
    
    public DataInitAppRunner(AccountService accountService,
        CompanyRepository companyRepository, RoleService roleService,
        LocationService locationService, TitleService titleService) {
        this.accountService = accountService;
        this.companyRepository = companyRepository;
        this.roleService = roleService;
        this.locationService = locationService;
        this.titleService = titleService;
    }
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*
         *   ======== Role ==========
         * */
        if (roleService.getAllRole().size() == 0) {
            roleService.createRole("ROLE_ADMIN", "Administrator of dashboard");
            roleService.createRole("ROLE_MANAGER", "Manager of dashboard");
            roleService.createRole("ROLE_USER", "A normal account with basic permission");
        }
        
        /*
         *   ======== Company ==========
         * */
        if (companyRepository.findAll().size() == 0) {
            Company company = new Company();
            company.setName("KMS Company");
            company.setDescription(
                "KMS Technology is a leading provider of offshore software development, testing services, and consulting");
            company.setStatus("Available");
            companyRepository.save(company);
            
            Company companyTwo = new Company();
            companyTwo.setName("NET Company");
            company.setDescription(
                "Netcompany was founded in 2000 and has its headquarters in Copenhagen, Denmark. Today, we are an international company with more than 3000 employees in 6 countries");
            companyTwo.setStatus("Available");
            companyRepository.save(companyTwo);
        }
        
        /*
         *   ======== Title ==========
         * */
        if (titleService.getAllTitle().size() == 0) {
            titleService.createTitle("Software Engineer",
                "Design and create computer systems and applications to solve real-world problems",
                LocalTime.now());
            titleService.createTitle("Marketing Analyst",
                "An individual who works to identify goods & services desired by a set of customers as well as marketing of those goods and services on behalf of the company",
                LocalTime.now());
        }
        
        /*
         *   ======== Location ==========
         * */
        if (locationService.getAllLocation().size() == 0) {
            locationService.initLocation("KMS Tản Viên", "123 Cong Hoa Tan Binh Ho Chi Minh", 1, 1);
            locationService.initLocation("KMS Trường Chinh",
                "1 Đ. Trường Chinh, Tây Thạnh, Tân Phú, Thành phố Hồ Chí Minh", 1, 1);
        }
        
        /*
         *   ======== Account ==========
         * */
        if (accountService.getAllAccount().size() == 0) {
            accountService.initAccount(
                "admin",
                BCrypt.hashpw("admin", BCrypt.gensalt()),
                1, 1, 1, 1
            );
            accountService.initAccount(
                "user",
                BCrypt.hashpw("user", BCrypt.gensalt()),
                3, 2, 1, 1
            );
        }
    }
}
