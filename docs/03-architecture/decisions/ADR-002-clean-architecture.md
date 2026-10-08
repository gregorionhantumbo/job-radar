# ADR-002: Use Clean Architecture

## Status

Accepted

## Context

JobRadar contains business rules related to:

* Users
* Skills
* Favorites
* Jobs
* Job requirements
* Matching
* Authentication

These rules should remain independent from infrastructure concerns.

## Decision

The backend will follow Clean Architecture principles.

## Reasons

* Separation of concerns
* Testability
* Dependency inversion
* Framework independence
* Maintainability
* Clear business boundaries

## Consequences

### Positive

* Business logic can be tested independently.
* Infrastructure can evolve independently.
* External integrations can be replaced more easily.
* The domain remains focused on business rules.

### Negative

* More classes and interfaces.
* Higher initial architectural complexity.
* Requires discipline from contributors.
