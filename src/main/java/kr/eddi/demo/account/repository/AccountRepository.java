package kr.eddi.demo.account.repository;

import jakarta.transaction.Transactional;
import kr.eddi.demo.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);

    Optional<Account> findByUserToken(String userToken);

    @Modifying
    @Transactional
    void deleteByEmail(String email);
}
