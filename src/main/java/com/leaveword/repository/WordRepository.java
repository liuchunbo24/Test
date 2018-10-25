package com.leaveword.repository;

import com.leaveword.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/7/24.
 */
public interface WordRepository extends JpaRepository<Word,Integer> {
}
