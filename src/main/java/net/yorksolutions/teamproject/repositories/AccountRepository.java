package net.yorksolutions.teamproject.repositories;

import net.yorksolutions.teamproject.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
