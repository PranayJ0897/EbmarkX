package com.embx.EmbarkX.companies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    private ResponseEntity<List<Company>> findAllCompanies() {
        List<Company> companyList = companyService.findAll();
        if (companyList.isEmpty())
            return new ResponseEntity<>(List.of(), HttpStatus.OK);
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @PostMapping()
    private ResponseEntity<String> createCompany(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.createCompany(company), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        boolean result = companyService.updateCompany(id, company);
        if (result)
            return new ResponseEntity<>("Company updated successfully!", HttpStatus.OK);
        else
            return new ResponseEntity<>("Company Not Found!", HttpStatus.NOT_FOUND);
    }
}
