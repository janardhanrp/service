package com.example.customer.fiegn;


import com.example.customer.Model.Account;
import com.example.customer.config.CustomerRetryClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Account", configuration = CustomerRetryClientConfig.class,fallbackFactory = HystrixFallBackFactory.class)
//@FeignClient(name = "ACCOUNT-SERVICE", fallbackFactory = HystrixFallBackFactory.class)
public interface AccountFeignClient {

    @GetMapping(value = "/account/id/{id}")
    Account getIds(@PathVariable Integer id);
}
