package io.getstream.butterfly

object Configuration {
  const val compileSdk = 31
  const val targetSdk = 31
  const val minSdk = 21
  const val majorVersion = 1
  const val minorVersion = 0
  const val patchVersion = 1
  const val versionName = "$majorVersion.$minorVersion.$patchVersion"
  const val versionCode = 2
  const val snapshotVersionName = "$majorVersion.$minorVersion.${patchVersion + 1}-SNAPSHOT"
  const val artifactGroup = "io.getstream"
}
