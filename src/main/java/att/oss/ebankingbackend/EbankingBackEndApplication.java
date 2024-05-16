package att.oss.ebankingbackend;

import att.oss.ebankingbackend.Dtos.CustomerDTO;
import att.oss.ebankingbackend.entities.*;
import att.oss.ebankingbackend.exceptions.BalanceNotSufficientException;
import att.oss.ebankingbackend.exceptions.BankAccountNotFoundException;
import att.oss.ebankingbackend.exceptions.CustomerNotFoundException;
import att.oss.ebankingbackend.repositories.BankAccountOperationRepository;
import att.oss.ebankingbackend.repositories.BankAccountRepository;
import att.oss.ebankingbackend.repositories.CustomerRepository;
import att.oss.ebankingbackend.services.BankAccountService;
import att.oss.ebankingbackend.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackEndApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService) {
        return args -> {
            Stream.of("o1", "o2", "o3").forEach(name -> {
                CustomerDTO customer = new CustomerDTO();
                customer.setName(name);
                customer.setEmail("oss@oss.com");
                bankAccountService.saveCustomer(customer);
            });

            bankAccountService.listCustomer().forEach(customer -> {
                try {
                    bankAccountService.saveCurrentAccount(Math.random() * 9000, 9000, customer.getId());
                    bankAccountService.saveSavingAccount(Math.random() * 12000, 5.5, customer.getId());
                    List<BankAccount> bankAccounts = bankAccountService.bankAccountList();
                    for (BankAccount account : bankAccounts) {
                        for(int i = 0; i<10; i++){
                            bankAccountService.credit(account.getId(), 10000 + Math.random() * 120000, "Credit");
                            bankAccountService.debit(account.getId(), 1000 + Math.random() * 9000, "Debit");
                        }
                    }
                } catch (CustomerNotFoundException | BalanceNotSufficientException e) {e.printStackTrace();}
                catch (BankAccountNotFoundException e) {e.printStackTrace();};
            });
        };
    }

    //@Bean
    CommandLineRunner start(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository, BankAccountOperationRepository bankAccountOperationRepository){
        return args -> {
            Stream.of("attouch","ossama","madrid").forEach(name->{
                Customer customer  = new Customer();
                customer.setName(name);
                customer.setEmail("oss@oss.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random()*9000);
                currentAccount.setCreateAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(customer);
                currentAccount.setOverDraft(9000);
                bankAccountRepository.save(currentAccount);

                    SavingAccount savingAccount = new SavingAccount();
                    savingAccount.setId(UUID.randomUUID().toString());
                    savingAccount.setBalance(Math.random()*9000);
                    savingAccount.setCreateAt(new Date());
                    savingAccount.setStatus(AccountStatus.CREATED);
                    savingAccount.setCustomer(customer);
                    savingAccount.setInterestRate(5.5);
                    bankAccountRepository.save(savingAccount);
            });

            bankAccountRepository.findAll().forEach(bankAccount -> {
                for (int i=0;i<5;i++) {
                AccountOperation accountOperation = new AccountOperation();
                accountOperation.setAmount(Math.random()*12000);
                accountOperation.setOperationDate(new Date());
                accountOperation.setType(Math.random()>0.5? OperationType.DEBIT:OperationType.CREDIT);
                accountOperation.setBankAccount(bankAccount);
                bankAccountOperationRepository.save(accountOperation);
                }
            });
        };
    }
}
