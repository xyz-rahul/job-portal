package com.example.jobPortal.service.implementation;

import com.example.jobPortal.entity.Company;
import com.example.jobPortal.payload.company.CompanyCreateDto;
import com.example.jobPortal.payload.company.CompanyDto;
import com.example.jobPortal.payload.company.CompanyUpdateDto;
import com.example.jobPortal.repository.CompanyRepository;
import com.example.jobPortal.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CompanyDto createCompany(CompanyCreateDto companyCreateDto) {
        Company companyToCreate = modelMapper.map(companyCreateDto, Company.class);
        Company savedCompany = companyRepository.save(companyToCreate);
        return modelMapper.map(savedCompany, CompanyDto.class);
    }

    @Override
    public List<CompanyDto> getAllCompanies(int pageNumber, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(
                sortDirection.equalsIgnoreCase("asc")
                        ? Sort.Direction.ASC:Sort.Direction.DESC,
                sortBy);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Company> companyPage = companyRepository.findAll(pageable);

        List<CompanyDto> companyDtos = companyPage.getContent().stream()
                .map(company -> modelMapper.map(company, CompanyDto.class))
                .collect(Collectors.toList());

        return companyDtos;
    }

    @Override
    public CompanyDto getCompanyById(int id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        return companyOptional.map(company -> modelMapper.map(company, CompanyDto.class)).orElse(null);
    }

    @Override
    public CompanyDto updateCompany(CompanyUpdateDto companyUpdateDto) {
        Integer companyId = companyUpdateDto.getId();
        Optional<Company> existingCompanyOptional = companyRepository.findById(companyId);
        if (existingCompanyOptional.isPresent()) {
            Company existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyUpdateDto, existingCompany);
            Company updatedCompany = companyRepository.save(existingCompany);
            return modelMapper.map(updatedCompany, CompanyDto.class);
        }
        return null;
    }

    @Override
    public boolean deleteCompany(int id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
