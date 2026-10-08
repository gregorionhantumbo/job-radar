# Functional Requirements

## Auth

### FR-001 — User Registration

The system must allow a user to create an account.

### FR-002 — User Authentication

The system must authenticate registered users.

### FR-003 — Authentication Token

The system must provide an authentication mechanism that allows protected resources to identify authenticated users.

### FR-004 — Authorization

The system must prevent users from accessing resources they are not authorized to access.

## Users

### FR-005 — User Profile

The system must allow users to maintain their profile information.

### FR-006 — Skill Management

The system must allow users to add, update, and remove skills associated with their profile.

### FR-007 — Favorite Job

The system must allow users to save a job as a favorite.

### FR-008 — Remove Favorite

The system must allow users to remove a job from their favorites.

### FR-009 — List Favorites

The system must allow users to retrieve their favorite jobs.

## Jobs

### FR-010 — Job Ingestion

The system must be capable of importing jobs from supported external sources.

### FR-011 — Job Storage

The system must store normalized job information.

### FR-012 — Job Requirements

The system must store requirements associated with jobs.

### FR-013 — Job Listing

The system must provide a list of available jobs.

### FR-014 — Job Details

The system must provide detailed information about a job.

### FR-015 — Original Source

An imported job should contain the original source URL whenever available.

## Matching

### FR-016 — Skill Matching

The system must compare user skills against job requirements.

### FR-017 — Match Score

The system must calculate a compatibility score.

### FR-018 — Job Ranking

The system should allow jobs to be ordered according to relevance.

## External Sources

### FR-019 — Source Identification

The system should identify the external source associated with each imported job.

### FR-020 — External Identifier

Where available, the system should preserve the external identifier of a job.
