package com.embx.EmbarkX.companies;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    String createCompany(Company company);

    boolean deleteCompany(Long id);

    boolean updateCompany(Long id, Company company);

}
