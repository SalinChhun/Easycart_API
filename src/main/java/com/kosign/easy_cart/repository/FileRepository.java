package com.kosign.easy_cart.repository;

import com.kosign.easy_cart.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
    File findByFileName(String fileName);
}
