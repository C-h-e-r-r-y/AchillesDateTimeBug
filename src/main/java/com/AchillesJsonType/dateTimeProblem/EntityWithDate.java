package com.AchillesJsonType.dateTimeProblem;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.Entity;
import info.archinnov.achilles.annotations.Id;
import org.joda.time.DateTime;

@Entity(table = "table_with_date")
public class EntityWithDate {

    @Id
    private String id;

    @Column
    private DateTime date;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(final DateTime date) {
        this.date = date;
    }
}
