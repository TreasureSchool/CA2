package facade;

import Entity.Address;
import Entity.Company;
import Entity.Phone;
import java.util.List;

/**
 * @author Joachim
 */
public interface ICompanyFacade {
    Company addCompany(Company company);

    Company getCompanyOnCvr(String cvr);

    Company getCompanyOnId(Long id);

    Company getCompanyOnPhone(String number);
    
    List<Company> getCompanies();

    Company addPhoneToCompany(Phone phone, long id);

    Company addAddressToCompany(Address address, long id);

    Company editCompany(Company company, long id);

    Company deleteCompany(long id);
}
