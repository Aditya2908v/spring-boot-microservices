package org.example.accounts.service.client;


import org.example.accounts.dto.CardsDto;
import org.example.accounts.dto.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("loans")
public interface LoansFeignClient {
    @GetMapping(value = "/api/fetch", consumes = "application.json")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam String mobileNumber);
}
