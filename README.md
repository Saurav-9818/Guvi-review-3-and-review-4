# Guvi-review-3-and-review-4
# Online Fitness Tracking System

## Overview
This project is a Maven-based Java application to track fitness activities for users.

## Features
- User registration and management.
- Logging of fitness activities.
- View fitness records by user.

## Setup
1. Clone the repository.
2. Run `mvn spring-boot:run`.
3. Access the API at `http://localhost:8080/api`.

## API Endpoints
- `POST /api/users` - Add a user.
- `POST /api/records` - Log a fitness record.
- `GET /api/records/{userId}` - Get fitness records for a user.
