package com.connoresau.codingtest.dao;


import com.connoresau.codingtest.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The dao repository for Log
 */
public interface LogDAO extends JpaRepository<Log, Integer> {
}
