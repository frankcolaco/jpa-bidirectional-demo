package com.example.jpa.manytomanydemo.repositories;

import com.example.jpa.manytomanydemo.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
