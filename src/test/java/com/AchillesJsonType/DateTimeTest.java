package com.AchillesJsonType;

import com.AchillesJsonType.dateTimeProblem.EntityWithDate;
import info.archinnov.achilles.persistence.PersistenceManager;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class DateTimeTest {
    private static final String ID = "some";
    @Autowired
    private PersistenceManager persistenceManager;

    @Test
    public void testName() throws Exception {
        EntityWithDate entity = new EntityWithDate();
        DateTime date = DateTime.now();
        entity.setDate(date);
        entity.setId(ID);
        persistenceManager.insert(entity);
        EntityWithDate found = persistenceManager.find(EntityWithDate.class, ID);
        Assert.assertEquals("Date received from cassandra = " + found.getDate() + System.lineSeparator() +
                "Original date=" + date, found.getDate(), date);
    }
}
