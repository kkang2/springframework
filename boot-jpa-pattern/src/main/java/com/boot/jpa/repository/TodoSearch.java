package com.boot.jpa.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boot.jpa.dto.TodoDTO;
import com.boot.jpa.entity.TodoEntity;                 
                                                                              
public interface TodoSearch {                                   
                                                                              
    Page<TodoEntity> search1(Pageable pageable);  
                                                                              
    Page<TodoDTO> searchDTO(Pageable pageable);
}                                                                            
