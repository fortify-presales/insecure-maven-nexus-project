<#
.SYNOPSIS
  Deploy custom-utils to a Nexus repository (PowerShell version).

USAGE
  Run with defaults (reads env vars if set):
    .\deploy-to-nexus.ps1

  Override values via env vars or parameters:
    $env:REPO_ID='fortify-presales'; $env:NEXUS_URL='https://nexus-repo.onfortify.com/repository/fortify-presales/'; $env:VERSION='1.0.0'; .\deploy-to-nexus.ps1

  Or pass parameters:
    .\deploy-to-nexus.ps1 -RepoId 'fortify-presales' -NexusUrl 'https://nexus-repo.onfortify.com/repository/fortify-presales/' -Version '1.0.0'
#>

[CmdletBinding()]
param(
    [string]$RepoId = $(if ($env:REPO_ID) { $env:REPO_ID } else { 'fortify-presales' }),
    [string]$NexusUrl = $(if ($env:NEXUS_URL) { $env:NEXUS_URL } else { 'https://nexus-repo.onfortify.com/repository/fortify-presales/' }),
    [string]$Version = $(if ($env:VERSION) { $env:VERSION } else { '1.0.0' })
)

$ErrorActionPreference = 'Stop'

try {
    Write-Host "Packaging project (skipping tests)..."
    & mvn -q -DskipTests package
    if ($LASTEXITCODE -ne 0) { throw "Maven package failed with exit code $LASTEXITCODE" }

    Write-Host "Deploying com.microfocus.internal:custom-utils:$Version to $NexusUrl (repo id: $RepoId)"
    & mvn deploy:deploy-file -DgroupId=com.microfocus.internal -DartifactId=custom-utils -Dversion="$Version" -Dpackaging=jar -Dfile="target/custom-utils-$Version.jar" -DrepositoryId="$RepoId" -Durl="$NexusUrl"
    if ($LASTEXITCODE -ne 0) { throw "Maven deploy failed with exit code $LASTEXITCODE" }

    Write-Host "Deployed com.microfocus.internal:custom-utils:$Version to $NexusUrl"
} catch {
    Write-Error "Deployment failed: $_"
    exit 1
}
