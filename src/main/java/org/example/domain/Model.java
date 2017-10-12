package org.example.domain;

import java.io.Serializable;

public abstract class Model implements Serializable
{
  private Long id;

  public Long getID()
  {
    return id;
  }

  public void setID(final Long id)
  {
    this.id = id;
  }
}
