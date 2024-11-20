package org.venuspj.htmx.admin.infra.api.projects;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.venuspj.htmx.admin.appl.command.project.CreateProjectCommand;
import org.venuspj.htmx.admin.appl.command.project.DeleteProjectCommand;
import org.venuspj.htmx.admin.appl.command.project.UpdateProjectCommand;
import org.venuspj.htmx.admin.appl.query.project.ProjectQuery;
import org.venuspj.htmx.admin.domain.model.project.Project;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/projects")
public class ProjectResource {

  private final ProjectQuery projectQuery;
  private final CreateProjectCommand createProjectCommand;
  private final UpdateProjectCommand updateProjectCommand;
  private final DeleteProjectCommand deleteProjectCommand;

  @GetMapping
  public Iterable<Project> getProjects() {
    return projectQuery.findAllProjects();
  }

  @GetMapping(path = "/{id}")
  public Project findById(@PathVariable Long id) {
    return projectQuery.findById(id).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            String.format("project not found. projectId: %s", id)));

  }

  @PostMapping
  public Project createProject(@RequestBody Project project) {
    return createProjectCommand.execute(Project.newInstance(project));
  }

  @PutMapping(path = "/{id}")
  public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
    return updateProjectCommand.execute(Project.updateInstance(id, project));
  }

  @DeleteMapping(path = "/{id}")
  public void deleteProject(@PathVariable Long id) {
    deleteProjectCommand.execute(id);

  }

}
