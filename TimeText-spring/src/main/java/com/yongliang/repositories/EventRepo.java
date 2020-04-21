package com.yongliang.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yongliang.model.Event;

public interface EventRepo extends JpaRepository<Event, Integer> {

}
