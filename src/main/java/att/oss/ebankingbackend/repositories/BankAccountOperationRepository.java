package att.oss.ebankingbackend.repositories;

import att.oss.ebankingbackend.entities.AccountOperation;
import att.oss.ebankingbackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountOperationRepository extends JpaRepository<AccountOperation,Long> {

}
