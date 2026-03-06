
# custom-utils (Internal Library)

Minimal internal Java library meant to be published to your Nexus repository and consumed by other apps.

**Coordinates**

GroupId: `com.microfocus.internal`

ArtifactId: `custom-utils`

Version: `1.0.0`

## Build
```bash
mvn -q clean package
```

The JAR will be at `target/custom-utils-1.0.0.jar`.

## Tests
Run unit tests:
```bash
mvn -q test
```

## Deploy to Nexus (Releases repository)
Use Maven's `deploy:deploy-file` (adjust URL and repository id for your Nexus):

```bash
mvn deploy:deploy-file \
  -DgroupId=com.microfocus.internal \
  -DartifactId=custom-utils \
  -Dversion=1.0.0 \
  -Dpackaging=jar \
  -Dfile=target/custom-utils-1.0.0.jar \
  -DrepositoryId=fortify-presales \
  -Durl=https://nexus-repo.onfortify.com/repository/fortify-presales/
```

Alternatively use the convenience scripts in this directory:

- Bash:
```bash
# set env vars if desired, otherwise defaults are used
REPO_ID=fortify-presales NEXUS_URL=https://nexus-repo.onfortify.com/repository/fortify-presales/ VERSION=1.0.0 ./deploy-to-nexus.sh
```

- PowerShell:
```powershell
# from custom-utils folder
#$env:REPO_ID='fortify-presales'; $env:NEXUS_URL='https://nexus-repo.onfortify.com/repository/fortify-presales/'; $env:VERSION='1.0.0'; .\deploy-to-nexus.ps1
```

Ensure your `~/.m2/settings.xml` contains credentials for `<id>fortify-presales</id>`.

## Logging
This library uses Log4j 2 (property `log4j.version` in the POM). Consumers should provide a `log4j2.xml` on the classpath to configure logging. The `sample-app` includes a simple `log4j2.xml` resource.

## Consume from another project
Add this dependency to the consumer project's `pom.xml`:
```xml
<dependency>
  <groupId>com.microfocus.internal</groupId>
  <artifactId>custom-utils</artifactId>
  <version>1.0.0</version>
</dependency>
```

Example usage (from Java):
```java
import com.microfocus.internal.StringHelper;
import com.microfocus.internal.SecurityExamples;

String s = StringHelper.shout("hello");
String q = SecurityExamples.buildInsecureQuery("alice");
```

## Insecure Examples (for SAST testing)
The `src/main/java/com/microfocus/internal/insecure` package contains intentionally insecure code patterns meant for static analysis testing (Fortify, SonarQube, etc.). These examples are for testing and educational purposes only — do NOT use them in production.

- **SQL injection:** `InsecureSQL` builds SQL queries via string concatenation.
- **Hardcoded credentials:** `HardcodedCredentials` stores a username/password as constants.
- **Weak cryptography:** `WeakCrypto` demonstrates MD5 hashing.
- **Insecure randomness:** `InsecureRandom` uses `java.util.Random` for token generation.
- **Command injection:** `CommandInjection` shows `Runtime.exec` with external input (do not call this in CI).
- **Unsafe deserialization:** `UnsafeDeserialization` reads objects with `ObjectInputStream` from untrusted data.

The `SecurityExamples` facade exposes a safe subset of methods for demos and testing. Avoid invoking methods that execute external commands or deserialize untrusted data in automated environments.

