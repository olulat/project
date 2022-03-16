package com.lateefolu.project.service;

import com.lateefolu.project.model.Project;
import com.lateefolu.project.repo.ProjectRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {
    @Mock
    private ProjectRepo projectRepo;
    private  ProjectService underTest;

@BeforeEach
void setUp(){

    underTest = new ProjectService(projectRepo);

}



    @Test
    void CanAddProject() {
    // giving
        Project project = new Project(
                "Dakota House",
                "Flat Building",
                "https://propertyheads.com/photos/46/89/e7/4689e7d7882fc5d.jpeg",
                "2399"
        );

    // when
        underTest.addProject(project);

        //then
        ArgumentCaptor<Project> projectArgumentCaptor = ArgumentCaptor.forClass(Project.class);

        verify(projectRepo).save(projectArgumentCaptor.capture());


      Project capturedProject = projectArgumentCaptor.getValue();

      assertThat(capturedProject).isEqualTo(project);

    }

    @Test
    void canGetAllProject() {

    // when
    underTest.viewAllProject();

    //then
        verify(projectRepo).findAll();
    }

}