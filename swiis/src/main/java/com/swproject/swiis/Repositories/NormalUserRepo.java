package com.swproject.swiis.Repositories;

import com.swproject.swiis.Entity.NormalUser;
import org.springframework.data.repository.CrudRepository;

public interface NormalUserRepo
        extends CrudRepository<NormalUser,String> {
}
