package com.tex.contextcache.dao;

import com.tex.contextcache.Task;
import com.tex.contextcache.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
