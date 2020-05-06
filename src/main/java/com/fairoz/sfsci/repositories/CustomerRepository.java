package com.fairoz.sfsci.repositories;

import com.fairoz.sfsci.model.Customer;
import com.fairoz.sfsci.model.GroupedCustomer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    @Query("SELECT AVG(timeTakenForProspect) FROM Customer WHERE timeTakenForProspect IS NOT NULL")
    Double avgTimeTakenForProspect();

    @Query("SELECT AVG(timeTakenForCustomer) FROM Customer WHERE timeTakenForCustomer IS NOT NULL")
    Double avgTimeTakenForCustomer();

    @Query("SELECT new com.fairoz.sfsci.model.GroupedCustomer(tag, firstName, lastName) FROM Customer ")
    List<GroupedCustomer> getGroupedCustomer();

}
