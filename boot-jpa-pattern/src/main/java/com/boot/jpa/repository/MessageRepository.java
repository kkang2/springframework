package com.boot.jpa.repository;
import org.springframework.data.repository.CrudRepository;

import com.boot.jpa.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}