package com.pplip.domain.auth.persistence.repository;


import com.pplip.domain.auth.persistence.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AccountRepository {

    Optional<Account> findByEmail(String username);


}
