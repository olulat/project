package com.lateefolu.project.repo;

import com.lateefolu.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    void deleteProjectById(Long id);

    Optional<Project> findProjectByProjectCode(String projectCode);
}
