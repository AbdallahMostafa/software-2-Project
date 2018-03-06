package Repositories;

import Entity.NormalUser;
import org.springframework.data.repository.CrudRepository;

public interface NormalUserRepo extends CrudRepository<NormalUser,String> {
}
