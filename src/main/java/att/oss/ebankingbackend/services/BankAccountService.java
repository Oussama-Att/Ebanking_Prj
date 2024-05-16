package att.oss.ebankingbackend.services;

import att.oss.ebankingbackend.Dtos.CustomerDTO;
import att.oss.ebankingbackend.entities.BankAccount;
import att.oss.ebankingbackend.entities.CurrentAccount;
import att.oss.ebankingbackend.entities.Customer;
import att.oss.ebankingbackend.entities.SavingAccount;
import att.oss.ebankingbackend.exceptions.BalanceNotSufficientException;
import att.oss.ebankingbackend.exceptions.BankAccountNotFoundException;
import att.oss.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    BankAccount saveBankAccount(double initialBalance, String type, Long customerId) throws CustomerNotFoundException;
    CurrentAccount saveCurrentAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomer();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId,double amount,String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId,double amount,String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void transfer(String accountIdSource,String accountIdDestination,double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;


    List<BankAccount> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;
}
