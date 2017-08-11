
Format for files is
   V<ordering>__<name>.sql

For ordering, use unix timestamp.
For name, use likely description.

Easiest creation is
   vim V`date +%s`__name.sql
