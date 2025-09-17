package com.embx.EmbarkX.companies;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    String createCompany(Company company);

    String deleteCompany(Long id);

    String updateCompany(Long id, Company company);

}
