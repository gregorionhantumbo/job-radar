# ADR-003: Use PostgreSQL

## Status

Accepted

## Context

JobRadar requires persistent storage for:

* Users
* Skills
* Favorites
* Jobs
* Job requirements
* External job source information

## Decision

PostgreSQL will be the primary database for the MVP.

## Reasons

* Mature relational database
* Strong transactional support
* Excellent Java/Spring integration
* Suitable for structured relational data
* Open source
* Strong ecosystem
* Suitable for the expected MVP

## Consequences

PostgreSQL becomes a core infrastructure dependency of the MVP.

The database schema must be version-controlled and reproducible across environments.
