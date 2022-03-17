package com.lateefolu.project.service;

import com.lateefolu.project.model.Project;
import io.swagger.v3.oas.annotations.Operation;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    @Operation(summary="Add project With Unique code")
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
    @Operation(summary="Get project using project code")
    public ResponseEntity<Project> getProjectByCode(@PathVariable("projectCode") String projectCode){
        Project project = projectService.findProjectByProjectCode(projectCode);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Project> updateProject(@RequestBody Project project){
        Project updateProject = projectService.addProject(project);
        return new ResponseEntity<>(updateProject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id){
       projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
