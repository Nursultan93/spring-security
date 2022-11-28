package com.example.bankapplicationrestsecurity.repository;

import com.example.bankapplicationrestsecurity.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
}
