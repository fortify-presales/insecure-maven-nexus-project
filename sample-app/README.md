# sample-app

Minimal sample application demonstrating use of the `custom-utils` internal library.

**Purpose**: show how to consume `custom-utils` (StringHelper and the `SecurityExamples` facade) and to exercise demo insecure patterns for SAST testing.

**Coordinates**
- GroupId: com.example
- ArtifactId: sample-app
- Version: 1.0.0

**Build**
- Compile:

```bash
cd sample-app
mvn -q compile
```

**Run**
- Run the main class using the configured exec plugin:

```bash
cd sample-app
mvn exec:java
```

- Pass args:

```bash
mvn exec:java -Dexec.args="arg1 arg2"
```

**What it demonstrates**
- Consumes `com.microfocus.internal:StringHelper`.
- Uses `com.microfocus.internal.SecurityExamples` facade to call example methods that delegate to intentionally insecure patterns (SQL concat, hardcoded creds, weak crypto, weak randomness).
- Installs an intentionally insecure "trust all" TLS handler at startup (`InsecureTrustAllSsl.installTrustAll()`); this is for demo/SAST only.

**Logging**
- The project uses Log4j2 for logging. `sample-app` contains a `log4j2.xml` resource to configure logging output.

**Security / SAST**
- The repository includes intentionally vulnerable code in `custom-utils` under `com.microfocus.internal.insecure` and one sample-app-only insecure example `InsecureTrustAllSsl`.
- These are provided solely to exercise static analysis tools (Fortify, SonarQube, etc.). Do NOT enable the insecure behaviors in production or CI pipelines that run against production systems.

**Run tests**
- Run unit tests for both modules (from repo root):

```bash
mvn -q -pl custom-utils -am test
```

**Notes**
- Ensure `custom-utils` artifact is installed or deployed to a repository available to `sample-app` before running if you changed coordinates.
- The `sample-app` `pom.xml` includes an `exec-maven-plugin` configuration so `mvn exec:java` will run `com.microfocus.example.app.App` by default.
