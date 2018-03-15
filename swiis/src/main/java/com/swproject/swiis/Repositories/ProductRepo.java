package com.swproject.swiis.Repositories;

import com.swproject.swiis.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product,String> {
}
