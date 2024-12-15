package com.boot.jpa.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.ex2.entity.QTodoEntity;

import com.boot.jpa.dto.TodoDTO;
import com.boot.jpa.entity.TodoEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.log4j.Log4j2; 
                                                                                                                                           
                                                                                                                                           
@Log4j2                                                                                                                              
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch{     
                                                                                                                                           
    public TodoSearchImpl() {                                                                                                
        super(TodoEntity.class);                                                                                               
    }                                                                                                                                     
                                                                                                                                           
    @Override                                                                                                                       
    public Page<TodoEntity> search1(Pageable pageable) {                                                    
                                                                                                                                           
        log.info("search1............");                                                                                         
                                                                                                                                           
        QTodoEntity todoEntity = QTodoEntity.todoEntity;                                                        
                                                                                                                                           
        JPQLQuery<TodoEntity> query = from(todoEntity);                                                      
                                                                                                                                           
        query.where(todoEntity.mno.gt(0L));                                                                           
                                                                                                                                           
        getQuerydsl().applyPagination(pageable, query);                                                           
                                                                                                                                           
        java.util.List<TodoEntity> entityList = query.fetch();                                                     
                                                                                                                                           
        long count = query.fetchCount();                                                                                 
                                                                                                                                           
        return new org.springframework.data.domain.PageImpl<>(entityList, pageable, count);
                                                                                                                                           
                                                                                                                                           
    }                                                                                                                                     
                                                                                                                                           
    @Override                                                                                                                       
    public Page<TodoDTO> searchDTO(Pageable pageable) {                                                  
                                                                                                                                           
        QTodoEntity todoEntity = QTodoEntity.todoEntity;                                                        
                                                                                                                                           
        JPQLQuery<TodoEntity> query = from(todoEntity);                                                      
                                                                                                                                           
        query.where(todoEntity.mno.gt(0L));                                                                           
                                                                                                                                           
        getQuerydsl().applyPagination(pageable, query);                                                           
                                                                                                                                           
        JPQLQuery<TodoDTO> dtoQuery =                                                                              
                query.select(Projections.constructor(TodoDTO.class, todoEntity));                        
                                                                                                                                           
        java.util.List<TodoDTO> dtoList = dtoQuery.fetch();                                                     
                                                                                                                                           
        long count = dtoQuery.fetchCount();                                                                           
                                                                                                                                           
        return new PageImpl<>(dtoList, pageable, count);                                                        
    }                                                                                                                                     
                                                                                                                                           
                                                                                                                                           
}                                                                                                                                         
