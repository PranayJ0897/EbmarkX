package com.embx.EmbarkX.companies.impl;

import com.embx.EmbarkX.companies.Company;
import com.embx.EmbarkX.companies.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Override
    public List<Company> findAll() {
        return List.of();
    }

    @Override
    public String createCompany(Company company) {
        return "";
    }

    @Override
    public String deleteCompany(Long id) {
        return "";
    }

    @Override
    public String updateCompany(Long id, Company company) {
        return "";
    }
}
