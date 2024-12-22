package com.mapping.repository;

import com.mapping.entity.BusStop;
import com.mapping.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Repository
    interface BusStopRepository extends JpaRepository<BusStop, Long> {

    }
}