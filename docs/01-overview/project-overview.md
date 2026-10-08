# Project Overview

## What is JobRadar?

JobRadar is an open-source job aggregation platform designed to help users discover job opportunities that are relevant to their skills.

Instead of requiring users to manually search across multiple job websites, JobRadar will collect job opportunities from external sources and compare their requirements with the skills stored in the user's profile.

## Problem

Job seekers may need to:

* Search multiple job websites.
* Repeatedly enter similar search criteria.
* Analyze job descriptions manually.
* Determine whether their skills match a particular opportunity.
* Find the original source of a job listing.

This can make job discovery time-consuming.

## Proposed Solution

JobRadar will provide a centralized platform for discovering relevant opportunities.

The planned process is:

```text
User
 |
 | Skills
 v
JobRadar
 |
 +---- Collect Jobs
 |
 +---- Normalize Job Data
 |
 +---- Analyze Requirements
 |
 +---- Compare Skills
 |
 +---- Calculate Match Score
 |
 v
Relevant Jobs
 |
 v
Original Job Source
```

## Main Concept

The user defines their skills.

JobRadar collects job opportunities and identifies the requirements associated with each job.

The system then compares the user's skills with the job requirements and calculates a compatibility score.

The result allows users to prioritize opportunities that are more relevant to their profile.

## Original Job Source

JobRadar should preserve the original source URL of an opportunity whenever possible.

The goal is not to replace the company or original publisher's recruitment process.

Instead, JobRadar acts as a discovery and matching layer.

## Project Philosophy

JobRadar is intended to be:

* Open source
* Community-oriented
* Maintainable
* Modular
* Transparent
* Extensible

The initial project is not intended to be commercialized.
