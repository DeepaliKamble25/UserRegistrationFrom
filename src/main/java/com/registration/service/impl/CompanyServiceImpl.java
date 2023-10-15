package com.registration.service.impl;

import com.registration.dao.CompanyDto;
import com.registration.entities.Company;
import com.registration.entities.User;
import com.registration.exception.ResourceNotFoundException;
import com.registration.payload.ApiConstant;
import com.registration.repository.CompanyRepository;
import com.registration.repository.UserRepository;
import com.registration.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CompanyDto createCompanydata(Long userId, CompanyDto companyDto) {

        Company company = this.modelMapper.map(companyDto, Company.class);
        Company savedCompany = this.companyRepository.save(company);
        return this.modelMapper.map(savedCompany, CompanyDto.class);
    }

    @Override
    public CompanyDto updateRecordCompany(Long userId, Long companyId, CompanyDto companyDto) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(ApiConstant.User_Not_Found));

        Company company = this.companyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException(ApiConstant.Company_Not_Found));
        
        company.setCompanyName(companyDto.getCompanyName());
        company.setCtc(companyDto.getCtc());
        company.setDateOfExits(companyDto.getDateOfExits());
        company.setAchievement(companyDto.getAchievement());
        company.setDateOfJoining(companyDto.getDateOfJoining());
        Company savedCompany = this.companyRepository.save(company);


        CompanyDto companyDto1 = this.modelMapper.map(savedCompany, CompanyDto.class);

        return companyDto1;
    }

    @Override
    public void deleteCompanydetailByUserDto(Long userId, Long companyId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(ApiConstant.User_Not_Found));

        Company company = this.companyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException(ApiConstant.Company_Not_Found));

      this.companyRepository.delete(company);
      this.userRepository.save(user);
    }

    @Override
    public List<CompanyDto> getall(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(ApiConstant.User_Not_Found));

        List<Company> allcompanys = this.companyRepository.findAll();
        List<CompanyDto> collect = allcompanys.stream().map(company -> this.modelMapper.map(company, CompanyDto.class)).collect(Collectors.toList());


        return collect;
    }
}
