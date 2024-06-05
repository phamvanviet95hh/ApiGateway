package com.apigateway.apigateway.repositorys;

import com.apigateway.apigateway.models.StaffModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends MongoRepository<StaffModel, String> {
    StaffModel findByEmail(String email);
}
