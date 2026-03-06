# insecure-maven-nexus-project

Monorepo containing a minimal internal Java library (`custom-utils`) and a `sample-app` that consumes it. The repo includes intentionally insecure example code to exercise static analysis tools (SAST) for testing and demonstrations.

Contents

- [custom-utils](custom-utils/README.md) — internal utilities library (publishes to Nexus). Contains insecure examples for SAST testing.
- [sample-app](sample-app/README.md) — sample consumer application demonstrating library usage and a sample-app-only insecure example.

Quick commands

- Build both modules:
```bash
mvn -q -T 1C clean install
```
- Run the sample-app:
```bash
cd sample-app
mvn exec:java
```
- Run tests for the library only:
```bash
cd custom-utils
mvn -q test
```

Security note

This repository intentionally contains unsafe code patterns under `com.microfocus.internal.insecure` and a demo `InsecureTrustAllSsl` in `sample-app`. These are provided only to test SAST tooling (Fortify, Sonar, etc.). Do NOT use insecure examples in production or enable them against production systems.