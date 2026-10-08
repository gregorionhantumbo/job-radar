# JobRadar

JobRadar is an open-source job aggregation platform that helps users discover job opportunities that match their skills.

## Objective

Aggregate job opportunities from external sources, analyze job requirements, match them against user skills, and provide access to the original job source.

## Running the Project

### Prerequisites

Before running JobRadar, install:

* Java 21
* Maven
* PostgreSQL
* Git

---

### Linux & macOS

#### 1. Clone the repository

```bash
git clone git@github.com:gregorionhantumbo/job-radar.git
cd job-radar
```

Or using HTTPS:

```bash
git clone https://github.com/gregorionhantumbo/job-radar.git
cd job-radar
```

#### 2. Configure the database

Create a PostgreSQL database and configure the required environment variables.

Example:

```bash
export DB_URL=
export DB_USERNAME=postgres
export DB_PASSWORD=your_password
```

#### 3. Run the application

```bash
./mvnw spring-boot:run
```

If the Maven wrapper is not available:

```bash
mvn spring-boot:run
```
---

### Windows

You can use **PowerShell** or **Command Prompt**.

#### 1. Clone the repository

Using SSH:

```powershell
git clone git@github.com:gregorionhantumbo/job-radar.git
cd job-radar
```

Or HTTPS:

```powershell
git clone https://github.com/gregorionhantumbo/job-radar.git
cd job-radar
```

#### 2. Configure the database

Using PowerShell:

```powershell
$env:DB_HOST="localhost"
$env:DB_PORT="5432"
$env:DB_NAME="job_radar"
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="your_password"
```

Using Command Prompt:

```cmd
set DB_HOST=localhost
set DB_PORT=5432
set DB_NAME=job_radar
set DB_USERNAME=postgres
set DB_PASSWORD=your_password
```

#### 3. Run the application

Using PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

Or, if Maven is installed globally:

```powershell
mvn spring-boot:run
```

---
## Documentation
Detailed project documentation is available in the [docs](docs) directory.

## License

This project is licensed under the terms defined in [LICENSE](LICENSE).