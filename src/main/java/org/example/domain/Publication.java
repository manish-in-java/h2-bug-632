package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "publication")
public class Publication extends Model
{
  @Column(length = 10, name = "access_level", nullable = false)
  @Enumerated(EnumType.STRING)
  private AccessLevel accessLevel;

  @Column(length = 100, name = "title", nullable = false)
  private String title;

  Publication()
  {
    super();
  }

  public Publication(final String title, final AccessLevel accessLevel)
  {
    this();

    this.accessLevel = accessLevel;
    this.title = title;
  }

  public AccessLevel getAccessLevel()
  {
    return accessLevel;
  }

  public String getTitle()
  {
    return title;
  }
}
