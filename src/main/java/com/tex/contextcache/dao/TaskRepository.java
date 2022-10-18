package com.tex.contextcache.dao;

import com.tex.contextcache.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
