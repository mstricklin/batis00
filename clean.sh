#!/usr/bin/env bash

MIGRATE_SCRIPTS=src/main/resources/db/hsqldb/migration/

flyway -user=sa -password=sa -url=jdbc:hsqldb:file:/Users/boobear/scratch/amt.db/amt -locations=filesystem:${MIGRATE_SCRIPTS} clean

