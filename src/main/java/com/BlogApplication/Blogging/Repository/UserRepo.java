package com.BlogApplication.Blogging.Repository;

import com.BlogApplication.Blogging.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo  extends JpaRepository<User, Integer>
{

}
