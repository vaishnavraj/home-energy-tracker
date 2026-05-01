package com.test.alertservice.repository;

import com.test.alertservice.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert,Long> {}
