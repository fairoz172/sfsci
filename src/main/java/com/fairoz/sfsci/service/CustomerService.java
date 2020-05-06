package com.fairoz.sfsci.service;

import com.fairoz.sfsci.web.dto.CustomerDto;
import com.fairoz.sfsci.web.dto.CustomerReportDto;
import com.fairoz.sfsci.web.dto.GroupedCustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomerService {

    Page<CustomerDto> getCustomers(Pageable pageable);

    CustomerReportDto getCustomerReport();

    List<GroupedCustomerDto> getGroupedCustomer();
}
