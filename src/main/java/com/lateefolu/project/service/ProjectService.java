package com.lateefolu.project.service;

import com.lateefolu.project.model.Project;
import com.lateefolu.project.repo.ProjectRepo;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Project addProject(Project NewProject){
        return projectRepo.save(NewProject);
    }
}
