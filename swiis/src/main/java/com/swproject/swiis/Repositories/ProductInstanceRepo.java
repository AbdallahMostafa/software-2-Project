package com.swproject.swiis.Repositories;

import com.swproject.swiis.Entity.ProductInstance;
import com.swproject.swiis.Entity.Store;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductInstanceRepo extends CrudRepository<ProductInstance,Long> {

}

