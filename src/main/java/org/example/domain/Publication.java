package org.example.domain;

public class Publication extends Model
{
  private AccessLevel accessLevel;

  private String title;

  public AccessLevel getAccessLevel()
  {
    return accessLevel;
  }

  public String getTitle()
  {
    return title;
  }

  public void setAccessLevel(final AccessLevel accessLevel)
  {
    this.accessLevel = accessLevel;
  }

  public void setTitle(final String title)
  {
    this.title = title;
  }
}
