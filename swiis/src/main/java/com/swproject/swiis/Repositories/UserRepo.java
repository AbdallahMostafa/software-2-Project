package com.swproject.swiis.Repositories;

import com.swproject.swiis.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, String> {
}
