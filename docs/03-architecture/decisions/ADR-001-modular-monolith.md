# ADR-001: Use a Modular Monolith

## Status

Accepted

## Context

JobRadar is an MVP and does not initially require independently deployable services.

The project also needs a simple development and deployment environment.

## Decision

The backend will be implemented as a modular monolith.

The initial business modules are:

```text
Auth
Users
Jobs
```

## Reasons

* Lower operational complexity
* Easier development
* Easier deployment
* Easier debugging
* Suitable for the expected MVP scale
* Clear internal module boundaries
* Avoids premature microservice complexity

## Consequences

### Positive

* Simple deployment
* Lower infrastructure requirements
* Easier local development
* Easier debugging
* Shared transaction/database infrastructure

### Negative

* Modules share the same runtime.
* A module cannot be independently deployed initially.
* Developers must maintain strict module boundaries.
