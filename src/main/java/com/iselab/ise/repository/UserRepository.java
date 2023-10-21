package com.iselab.ise.repository;

import com.iselab.ise.model.POJO.Slides;
import com.iselab.ise.model.POJO.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

}
