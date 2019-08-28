package com.waiter.authentication.user.repository;


import com.waiter.authentication.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Optional<User> findByLoginId(String username);
}
