package att.oss.ebankingbackend.repositories;

import att.oss.ebankingbackend.entities.AccountOperation;
import att.oss.ebankingbackend.entities.BankAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountOperationRepository extends JpaRepository<AccountOperation,Long> {
    List<AccountOperation> findByBankAccountId(String accountId);
    Page<AccountOperation> findByBankAccountIdOrderByOperationDateDesc(String accountId, Pageable pageable);
    Page<AccountOperation> findByBankAccountId(String accountId, Pageable pageable);

}
