package org.venuspj.htmx.admin.domain.model.project;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.venuspj.htmx.common.util.provider.datetime.DateProvider;
import org.venuspj.htmx.shared.domain.type.snowflakeId.SnowflakeId;

@Entity
@Table(name = "projects")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Project {

  @Id
  private Long id;
  private String name;
  private String description;
  @Column(name = "last_updated_at")
  private LocalDateTime lastUpdatedAt;

  public static Project newInstance(Project sourceProject) {
    if (sourceProject == null) {
      throw new IllegalArgumentException("sourceProject cannot be null");
    }
    return new Project(SnowflakeId.newInstance().getValue(),
        sourceProject.name,
        sourceProject.description,
        DateProvider.currentLocalDateTime());
  }

  public static Project updateInstance(Long id, Project sourceProject) {
    if (sourceProject == null) {
      throw new IllegalArgumentException("sourceProject cannot be null");
    }
    return new Project(id,
        sourceProject.name,
        sourceProject.description,
        DateProvider.currentLocalDateTime());
  }
}
