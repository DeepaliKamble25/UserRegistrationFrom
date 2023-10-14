package com.registration.service;

import com.registration.dao.CompanyDto;
import com.registration.dao.UserDto;

import java.util.List;

public interface CompanyService {

    CompanyDto createCompanydata(CompanyDto companyDto);

    CompanyDto updateRecordCompany(Long userId,Long companyId);

    void deleteCompanydetailByUserDto(Long userId,Long companyId);

    List<CompanyDto> getall(Long userId);




}
