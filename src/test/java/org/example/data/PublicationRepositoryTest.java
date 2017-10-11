package org.example.data;

import org.example.domain.AccessLevel;
import org.example.domain.Publication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PublicationRepositoryTest
{
  @Autowired
  private PublicationRepository repository;

  @Before
  public void setup()
  {
    for (int i = 0; i < 5; ++i)
    {
      for (final AccessLevel accessLevel : AccessLevel.values())
      {
        repository.saveAndFlush(new Publication(UUID.randomUUID().toString(), accessLevel));
      }
    }
  }

  @Test
  public void testFindAllByNullAccessLevelAndNullTitle()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitle(null, null));
  }

  @Test
  public void testFindAllByNonNullAccessLevelAndNullTitle()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitle(AccessLevel.PUBLIC, null));
  }

  @Test
  public void testFindAllByNullAccessLevelAndNonNullTitle()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitle(null, UUID.randomUUID().toString()));
  }

  @Test
  public void testFindAllByNonNullAccessLevelAndNonNullTitle()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitle(AccessLevel.PUBLIC, UUID.randomUUID().toString()));
  }

  @Test
  public void testFindAllByNullAccessLevelAndNullTitleLike()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitleLike(null, null));
  }

  @Test
  public void testFindAllByNonNullAccessLevelAndNullTitleLike()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitleLike(AccessLevel.PRIVATE, null));
  }

  @Test
  public void testFindAllByNullAccessLevelAndNonNullTitleLike()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitleLike(null, UUID.randomUUID().toString()));
  }

  @Test
  public void testFindAllByNonNullAccessLevelAndNonNullTitleLike()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitleLike(AccessLevel.PRIVATE, UUID.randomUUID().toString()));
  }
}
