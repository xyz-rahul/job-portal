package com.example.jobPortal.service;

import com.example.jobPortal.payload.company.CompanyCreateDto;
import com.example.jobPortal.payload.company.CompanyDto;
import com.example.jobPortal.payload.company.CompanyUpdateDto;

import java.util.List;

public interface CompanyService {

    CompanyDto createCompany(CompanyCreateDto companyCreateDto);

    List<CompanyDto> getAllCompanies(int pageNumber, int pageSize, String sortBy, String sortDirection);

    CompanyDto getCompanyById(int id);

    CompanyDto updateCompany(CompanyUpdateDto companyUpdateDto);

    boolean deleteCompany(int id);
}
