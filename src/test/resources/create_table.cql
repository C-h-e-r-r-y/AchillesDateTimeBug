create keyspace myKeySpace with replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE COLUMNFAMILY IF NOT EXISTS table_with_date (
	id text,
	date text,
	PRIMARY KEY (id)
);
