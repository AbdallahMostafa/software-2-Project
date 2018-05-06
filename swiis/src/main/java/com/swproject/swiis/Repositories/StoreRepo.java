package com.swproject.swiis.Repositories;

import com.swproject.swiis.Entity.Store;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface StoreRepo extends CrudRepository<Store,String> {
    public Set<Store> findByStoreOwnerUserName(String STORE_OWNER_USER_NAME );
}
