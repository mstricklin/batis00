#!/usr/bin/env bash

DB_LOC=/tmp/scratch/amt.db/amt
MIGRATE_SCRIPTS=src/main/resources/db/hsqldb/migration/

flyway -user=sa -password=sa -url=jdbc:hsqldb:file:${DB_LOC} -locations=filesystem:${MIGRATE_SCRIPTS} migrate

