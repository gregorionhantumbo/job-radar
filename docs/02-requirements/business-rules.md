# Business Rules

## Auth

* A user must have a unique identity.
* Authentication must only be possible for valid registered users.
* Passwords must never be stored in plaintext.
* Protected resources must require authentication when appropriate.

## Users

* A user's skills belong to that user.
* A user should only be able to manage their own profile.
* A user should only be able to manage their own skills.
* A user should only be able to manage their own favorites.
* A user should not have duplicate favorites for the same job.

## Jobs

* A job must originate from an external source or another explicitly supported ingestion mechanism.
* A job should preserve its original source URL whenever available.
* Jobs must be identifiable independently of their external source.
* External provider-specific data should not leak into the core domain unnecessarily.

## Matching

The initial matching strategy will compare normalized user skills with normalized job requirements.

The exact scoring formula will be finalized before implementation.

The MVP matching algorithm should be:

* Deterministic
* Understandable
* Testable
* Reproducible

Semantic and AI-based matching are outside the MVP.

## Favorites

* A user can favorite a job.
* A user cannot have the same job favorited more than once.
* Removing a favorite must not delete the job.
* A favorite belongs to the user who created it.

## Job Retention

A favorite should remain associated with the stored job even if the external source later changes or stops returning the opportunity, provided that the JobRadar job record remains available.
