package att.oss.ebankingbackend.mappers;

import att.oss.ebankingbackend.Dtos.AccountOperationDTO;
import att.oss.ebankingbackend.Dtos.CurrentBankAccountDTO;
import att.oss.ebankingbackend.Dtos.CustomerDTO;
import att.oss.ebankingbackend.Dtos.SavingBankAccountDTO;
import att.oss.ebankingbackend.entities.AccountOperation;
import att.oss.ebankingbackend.entities.CurrentAccount;
import att.oss.ebankingbackend.entities.Customer;
import att.oss.ebankingbackend.entities.SavingAccount;
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

    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount){
    SavingBankAccountDTO savingBankAccountDTO = new SavingBankAccountDTO();
    BeanUtils.copyProperties(savingAccount,savingBankAccountDTO);
    savingBankAccountDTO.setCustomerDTO(fromCustomer(savingAccount.getCustomer()));
    savingBankAccountDTO.setType(savingAccount.getClass().getSimpleName());
    return savingBankAccountDTO;
    }

    public SavingAccount fromSavingBankAccountDTO(SavingBankAccountDTO savingBankAccountDTO){
    SavingAccount savingAccount = new SavingAccount();
    BeanUtils.copyProperties(savingBankAccountDTO,savingAccount);
    savingAccount.setCustomer(fromCustomer(savingBankAccountDTO.getCustomerDTO()));
    return savingAccount;
    }

    public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount){
    CurrentBankAccountDTO currentBankAccountDTO = new CurrentBankAccountDTO();
    BeanUtils.copyProperties(currentAccount,currentBankAccountDTO);
    currentBankAccountDTO.setCustomerDTO(fromCustomer(currentAccount.getCustomer()));
        currentBankAccountDTO.setType(currentAccount.getClass().getSimpleName());
    return currentBankAccountDTO;
    }

    public CurrentAccount fromCurrentBankAccountDTO(CurrentBankAccountDTO currentBankAccountDTO){
    CurrentAccount currentAccount = new CurrentAccount();
    BeanUtils.copyProperties(currentBankAccountDTO,currentAccount);
    currentAccount.setCustomer(fromCustomer(currentBankAccountDTO.getCustomerDTO()));
    return currentAccount;
    }

    public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation){
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
        BeanUtils.copyProperties(accountOperation,accountOperationDTO);
        return accountOperationDTO;
    }

}


