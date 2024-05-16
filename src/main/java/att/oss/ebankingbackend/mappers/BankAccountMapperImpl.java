package att.oss.ebankingbackend.mappers;

import att.oss.ebankingbackend.Dtos.CustomerDTO;
import att.oss.ebankingbackend.entities.Customer;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {
    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO =new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
       /* customerDTO.setId(customer.getId());
        customerDTO.setEmail(customerDTO.getEmail());
        customerDTO.setName(customerDTO.getName());*/
        return customerDTO;
    }
    public Customer fromCustomer(CustomerDTO customerDTO){
        Customer customer =new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return customer;
    }
}

//Recupe