# DB dump for savings and investment application:

### DB used : PostgreSQL

This is the complete databse dump for the application.
To restore the dump, run the below command:

> psql -U postgres -d new_db_name < savings_dump.sql

| Command            | Description                                                     |
| ------------------ | --------------------------------------------------------------- |
| psql               | The PostgreSQL command-line client                              |
| -U postgres        | Connect as user postgres (this is the DB user, not DB name)     |
| -d new_db_name     | The name of the database you're restoring the dump into         |
| < savings_dump.sql | Redirect the SQL dump file into psql (restores data and schema) |
