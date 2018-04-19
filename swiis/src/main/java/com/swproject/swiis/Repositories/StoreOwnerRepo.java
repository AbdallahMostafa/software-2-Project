package com.swproject.swiis.Repositories;

import com.swproject.swiis.Entity.NormalUser;
import com.swproject.swiis.Entity.StoreOwner;
import org.springframework.data.repository.CrudRepository;

public interface StoreOwnerRepo extends CrudRepository<NormalUser,String> {
}
