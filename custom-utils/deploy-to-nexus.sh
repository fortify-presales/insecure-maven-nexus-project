
#!/usr/bin/env bash
set -euo pipefail

# Usage:
#   REPO_ID=fortify-presales #   NEXUS_URL=https://nexus-repo.onfortify.com/repository/fortify-presales/ #   VERSION=1.0.0 #   ./deploy-to-nexus.sh

REPO_ID="${REPO_ID:-fortify-presales}"
NEXUS_URL="${NEXUS_URL:-https://nexus-repo.onfortify.com/repository/fortify-presales/}"
VERSION="${VERSION:-1.0.0}"

mvn -q -DskipTests package

mvn deploy:deploy-file   -DgroupId=com.microfocus.internal   -DartifactId=custom-utils   -Dversion="${VERSION}"   -Dpackaging=jar   -Dfile="target/custom-utils-${VERSION}.jar"   -DrepositoryId="${REPO_ID}"   -Durl="${NEXUS_URL}"

echo "Deployed com.microfocus.internal:custom-utils:${VERSION} to ${NEXUS_URL}"
