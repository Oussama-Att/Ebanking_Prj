package att.oss.ebankingbackend.Dtos;

import att.oss.ebankingbackend.entities.AccountStatus;
import att.oss.ebankingbackend.entities.Customer;
import lombok.Data;

import java.util.Date;

@Data
public class CurrentBankAccountDTO extends BankAccountDTO{
    private String id;
    private double balance;
    private Date createAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double overDraft;
}
