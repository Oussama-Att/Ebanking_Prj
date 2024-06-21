package att.oss.ebankingbackend.web;

import att.oss.ebankingbackend.Dtos.CustomerDTO;
import att.oss.ebankingbackend.entities.Customer;
import att.oss.ebankingbackend.exceptions.CustomerNotFoundException;
import att.oss.ebankingbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    @PreAuthorize("hasAnyAuthority('SCOPE_USER')")
    public List<CustomerDTO> customerList(){
        return bankAccountService.listCustomer();
    }

    @GetMapping("/customers/search")
    @PreAuthorize("hasAnyAuthority('SCOPE_USER')")
    public List<CustomerDTO> searchCustomers(@RequestParam(name="keyword",defaultValue =" ") String keyword){
        return bankAccountService.searchCustomers("%"+keyword+"%");
    }

    @GetMapping("/customers/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_USER')")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }

    @PostMapping("customers")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return bankAccountService.saveCustomer(customerDTO);
    }

    @PutMapping("/customers/{customerId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    public CustomerDTO updateCustomer(@PathVariable Long customerId,@RequestBody CustomerDTO customerDTO){
    customerDTO.setId(customerId);
    return bankAccountService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/customers/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    public void deleteCustomer(@PathVariable Long id){
    bankAccountService.deleteCustomer(id);
    }
}
