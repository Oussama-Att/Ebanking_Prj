package att.oss.ebankingbackend.web;

import att.oss.ebankingbackend.Dtos.CustomerDTO;
import att.oss.ebankingbackend.entities.Customer;
import att.oss.ebankingbackend.exceptions.CustomerNotFoundException;
import att.oss.ebankingbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    public List<CustomerDTO> customerList(){
        return bankAccountService.listCustomer();
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }

    @PostMapping("customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return bankAccountService.saveCustomer(customerDTO);
    }
}
