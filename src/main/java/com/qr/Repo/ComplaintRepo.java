package com.qr.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.qr.Entity.Complaint;

public interface ComplaintRepo extends MongoRepository<Complaint, String> {

}
