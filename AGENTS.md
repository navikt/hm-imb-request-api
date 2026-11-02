# Project instructions

## Stack and layout
- Kotlin 2.3.21, Micronaut 5.2.0, Java 25, Gradle wrapper, and KSP.
- Application code: src/main/kotlin/no/nav/hm/imb/request/api.
- Configuration: src/main/resources/application.yml.
- Tests belong in src/test/kotlin.
- Persistence uses PostgreSQL, Micronaut Data JDBC, and Flyway.
- Authentication uses Micronaut Security JWT.

## Commands
- Compile: ./gradlew classes
- Test: ./gradlew test
- Run a targeted test: ./gradlew test --tests 'fully.qualified.TestClass'
- Build: ./gradlew build
- Run locally: ./gradlew run
- Use JDK 25 and the Gradle wrapper.
- Local database defaults use Testcontainers and require Docker.
- The test task permits no discovered tests; a successful run alone
  does not prove that tests executed.

## Coding conventions
- Follow existing Kotlin and Micronaut patterns.
- Make focused changes and preserve existing behavior.
- Do not add code comments unless explicitly requested.
- Do not add dependencies without justification.
- Do not modify generated files in build/.
- Add regression tests for behavior changes.
- Run the smallest relevant validation command.

## Safety
- Never read or expose dev.env, credentials, or bearer tokens.
- Never place secrets in source code or OpenCode configuration.
- Do not deploy, push, or perform destructive Git operations
  without explicit approval.