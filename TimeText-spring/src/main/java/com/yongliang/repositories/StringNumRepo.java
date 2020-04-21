package com.yongliang.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yongliang.model.StringNum;

public interface StringNumRepo extends JpaRepository<StringNum, Integer> {

}
