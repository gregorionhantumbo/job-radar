# Non-Functional Requirements

## NFR-001 — Architecture

The backend should follow Clean Architecture principles.

## NFR-002 — Modularity

The application should be organized as a modular monolith with three main modules:

* Auth
* Users
* Jobs

## NFR-003 — Java

The backend will use Java 21.

## NFR-004 — Database

PostgreSQL will be used as the primary relational database.

## NFR-005 — API

The backend will expose a REST API.

## NFR-006 — Security

Authentication and authorization must be implemented.

## NFR-007 — Testing

Core business rules must have automated tests.

## NFR-008 — Configuration

Environment-specific configuration must not contain committed secrets.

## NFR-009 — Maintainability

The codebase should prioritize clear boundaries and separation of responsibilities.

## NFR-010 — Containerization

The application should be capable of running in Docker.

## NFR-011 — Testability

Business rules should be testable independently from infrastructure whenever possible.

## NFR-012 — Extensibility

The architecture should allow new job sources to be added without modifying the core job domain unnecessarily.
