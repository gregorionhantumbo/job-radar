# Use Cases

## UC-001 — Register User

**Actor:** User

```text
User
 |
 | registration data
 v
Auth
 |
 | validate
 |
 | create account
 v
User Account
```

## UC-002 — Authenticate User

**Actor:** User

```text
User
 |
 | credentials
 v
Auth
 |
 | validate
 v
Authenticated User
 |
 v
Authentication Token
```

## UC-003 — Manage Profile

**Actor:** User

```text
User
 |
 v
Users
 |
 v
User Profile
```

## UC-004 — Manage Skills

**Actor:** User

```text
User
 |
 v
Users
 |
 v
Skills
```

## UC-005 — Discover Jobs

**Actor:** User

```text
User
 |
 v
Jobs
 |
 +-- retrieve jobs
 |
 +-- calculate relevance
 |
 v
Job List
```

## UC-006 — View Job Details

**Actor:** User

```text
User
 |
 v
Jobs
 |
 v
Job Details
 |
 v
Original Job Source
```

## UC-007 — Favorite Job

**Actor:** User

```text
User
 |
 v
Users
 |
 v
Favorites
 |
 v
Job
```

## UC-008 — Remove Favorite

**Actor:** User

```text
User
 |
 v
Users
 |
 v
Favorites
 |
 v
Remove Favorite
```

## UC-009 — Aggregate Jobs

**Actor:** System

```text
External Job Source
 |
 v
Jobs
 |
 v
Normalize Job
 |
 v
Store Job
```

## UC-010 — Match User With Jobs

**Actor:** System

```text
User Skills
     |
     v
Jobs
     |
     v
Job Requirements
     |
     v
Skill Comparison
     |
     v
Match Score
     |
     v
Relevant Jobs
```
