package att.oss.ebankingbackend.repositories;

import att.oss.ebankingbackend.entities.BankAccount;
import att.oss.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

}
