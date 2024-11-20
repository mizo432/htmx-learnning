package org.venuspj.htmx.admin.appl.query.project;

import java.util.Optional;
import org.venuspj.htmx.admin.domain.model.project.Project;

public interface ProjectQuery {

  Iterable<Project> findAllProjects();

  Optional<Project> findById(Long id);

}
