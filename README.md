# UB Study-Group Scheduler
CSI142 Object Oriented Programming — Semester II 2025/26
University of Botswana, Department of Computer Science

---

## Project Overview
A Java console application that allows University of Botswana students to create
and manage study groups, schedule sessions, track members, and generate reports.

## Domain
Campus and Youth Life — students at UB form study groups informally through
WhatsApp. This system gives them a structured console-based tool to manage
everything in one place.

---

## Team Members
| Name              | Role                      |
|-------------------|---------------------------|
| Naledi Masilo     | Team Lead / OOP Design    |
| Keith Wallace     | Core Developer            |
| Moagisi Ramatlae  | Core Developer            |
| Thuto Tyler Thapo | Testing & Documentation   |
| Loago Amogelang   | Git & Integration         |

---

## How to Compile and Run (from project root)

1) Compile all source files:

   Windows:
   javac -d out src/ub/csi142/studygroupscheduler/app/MainApp.java

   Mac/Linux:
   find src -name "*.java" | xargs javac -d out

2) Run the program:
   java -cp out ub.csi142.studygroupscheduler.app.MainApp

> The app starts with 2 pre-loaded groups so you can demo immediately.

---

## Features
| Option | Feature                      |
|--------|------------------------------|
| 1      | Create a study group         |
| 2      | Add student to a group       |
| 3      | Schedule a session           |
| 4      | View all groups              |
| 5      | View sessions for a group    |
| 6      | View all sessions            |
| 7      | Update session status        |
| 8      | Search groups by course code |
| 9      | View group members           |
| 10     | Print groups report          |
| 0      | Exit                         |