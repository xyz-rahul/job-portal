package com.example.jobPortal.controller;

import com.example.jobPortal.payload.company.CompanyCreateDto;
import com.example.jobPortal.payload.company.CompanyDto;
import com.example.jobPortal.payload.company.CompanyUpdateDto;
import com.example.jobPortal.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompany(@PathVariable("id") int id) {
        CompanyDto company = companyService.getCompanyById(id);
        if (company != null) {
            CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);
            return new ResponseEntity<>(companyDto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyCreateDto companyCreateDto) {
        CompanyDto createdCompany = companyService.createCompany(companyCreateDto);

        if (createdCompany != null) {
            CompanyDto createdCompanyDto = modelMapper.map(createdCompany, CompanyDto.class);
            return new ResponseEntity<>(createdCompanyDto, HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<CompanyDto> updateCompany(@RequestBody CompanyUpdateDto companyUpdateDto) {
        CompanyDto updatedCompany = companyService.updateCompany(companyUpdateDto);
        if (updatedCompany != null) {
            CompanyDto updatedCompanyDto = modelMapper.map(updatedCompany, CompanyDto.class);
            return new ResponseEntity<>(updatedCompanyDto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") int id) {
        boolean deleted = companyService.deleteCompany(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<CompanyDto>> getAllCompanies(
            @RequestParam(value = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "size", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDirection", required = false, defaultValue = "asc") String sortDirection
    ) {
        List<CompanyDto> companies = companyService.getAllCompanies(pageNumber, pageSize, sortBy, sortDirection);
        if (!companies.isEmpty()) {
            return new ResponseEntity<>(companies, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
