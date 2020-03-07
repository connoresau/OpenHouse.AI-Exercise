package com.connoresau.codingtest.dao;

import com.connoresau.codingtest.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The dao repository for Action
 */
public interface ActionDAO extends JpaRepository<Action, Integer> {
}
