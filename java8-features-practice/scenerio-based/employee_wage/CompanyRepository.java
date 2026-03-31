package employee_wage;
import java.util.*;

import employee_wage.CompanyEmployeeWage;

public class CompanyRepository {

    private List<CompanyEmployeeWage> companies = new ArrayList<>();

    public void addCompany(CompanyEmployeeWage company) {
        companies.add(company);
    }

    public List<CompanyEmployeeWage> getAllCompanies() {
        return companies;
    }

    public CompanyEmployeeWage getCompanyByName(String name) {
        for(CompanyEmployeeWage company : companies) {
            if(company.getCompanyName().equalsIgnoreCase(name)) {
            	return company;
            }
        }
        return null;
    }
}