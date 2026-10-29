@echo off
rem Usage (Windows):  sql\learn\check.cmd 01     or     sql\learn\check.cmd all
rem Needs the SQL_LEARN_* environment variables, see sql/learn/README.md
if "%1"=="" (
  echo Usage: sql\learn\check.cmd 01   ^(lesson number, or "all"^)
  exit /b 1
)
cd /d "%~dp0..\.."
mvn -q test -Dtest=SqlLessonCheckTest -Dlesson=%1
