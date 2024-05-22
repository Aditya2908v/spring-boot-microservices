package org.example.accounts.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.accounts.dto.AccountDto;
import org.example.accounts.dto.CardsDto;
import org.example.accounts.dto.CustomerDetailsDto;
import org.example.accounts.dto.LoansDto;
import org.example.accounts.exception.ResourceNotFoundException;
import org.example.accounts.mapper.AccountsMapper;
import org.example.accounts.mapper.CustomerMapper;
import org.example.accounts.models.Account;
import org.example.accounts.models.Customer;
import org.example.accounts.repository.AccountRepository;
import org.example.accounts.repository.CustomerRepository;
import org.example.accounts.service.CustomerService;
import org.example.accounts.service.client.CardsFeignClient;
import org.example.accounts.service.client.LoansFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final CardsFeignClient cardsFeignClient;
    private final LoansFeignClient loansFeignClient;
    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Account account = accountRepository.findByCustomerId(customer.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getId().toString())
        );
        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountDto(AccountsMapper.mapToAccountDto(account, new AccountDto()));

        //Feign client will connect with the Eureka Server and try to get the loans
        //instance details, and it will perform some load balancing and invoke the actual microservice
        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
