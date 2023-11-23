package com.example.ChatGpt.repo;

import com.example.ChatGpt.dao.Chats;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ChatsRepo extends JpaRepository<Chats, Integer> {

    @Override
    public List<Chats> findAll();

    @Modifying
    @Query(value = "INSERT INTO chats (request, response) VALUES(:request, :response)", nativeQuery = true)
    void addChats(@Param("request") String request, @Param("response") String response);

}
