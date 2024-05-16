package att.oss.ebankingbackend.services;

import att.oss.ebankingbackend.entities.BankAccount;
import att.oss.ebankingbackend.entities.CurrentAccount;
import att.oss.ebankingbackend.entities.SavingAccount;
import att.oss.ebankingbackend.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount = bankAccountRepository.findById("72235f5f-90db-4a8e-a567-5078bf174743").orElse(null);
        if(bankAccount!=null){
            System.out.println("*************************************************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getCreateAt());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());

            if (bankAccount instanceof CurrentAccount){
                System.out.println("OverDraft==>"+((CurrentAccount)bankAccount).getOverDraft());
            }
            else {
                System.out.println("Rate==>"+((SavingAccount)bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperation().forEach(op -> {
                System.out.println(op.getType() + "\t" + op.getOperationDate() + op.getAmount());
            });
        }
        else {
            System.out.println("Account does not exist");
        }
    }
}
