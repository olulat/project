package com.lateefolu.project.repo;

import com.lateefolu.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    boolean findByProjectCode(String projectCode);
}
