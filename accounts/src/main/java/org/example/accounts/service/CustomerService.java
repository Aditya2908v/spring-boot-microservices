package org.example.accounts.service;

import org.example.accounts.dto.CustomerDetailsDto;

public interface CustomerService {
    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
