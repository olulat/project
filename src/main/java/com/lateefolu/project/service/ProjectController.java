package com.lateefolu.project.service;

import com.lateefolu.project.model.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        Project newProject = projectService.addProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAllProject(){
        List<Project> projects = projectService.viewAllProject();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/find/{projectCode}")
    public ResponseEntity<Project> getProjectByCode(@PathVariable("projectCode") String projectCode){
        Project project = projectService.findProjectByProjectCode(projectCode);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
