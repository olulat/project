package com.lateefolu.project.service;

import com.lateefolu.project.exception.ProjectNotFoundException;
import com.lateefolu.project.model.Project;
import com.lateefolu.project.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Project addProject(Project NewProject){
        return projectRepo.save(NewProject);
    }

    public List<Project> viewAllProject(){
        return projectRepo.findAll();
    }

    public Project findProjectByProjectCode(String projectCode){
        return projectRepo.findProjectByProjectCode(projectCode).orElseThrow(
                () ->new  ProjectNotFoundException("Project with " + projectCode + " was not found" ));
    }

    public  Project updateProject(Project project){
        return projectRepo.save(project);
    }


}
