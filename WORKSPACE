load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "2.8"
RULES_JVM_EXTERNAL_SHA = "79c9850690d7614ecdb72d68394f994fef7534b292c4867ce5e7dec0aa7bdfad"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
maven_install(
    name = "maven_deps",
    artifacts = [
        "com.fasterxml.jackson.core:jackson-databind:2.0.1",
        "io.vertx:vertx-config-yaml:4.0.2",
        "io.vertx:vertx-config:4.0.2",
        "io.vertx:vertx-rx-java2:4.0.2",
        "io.vertx:vertx-web:4.0.2",
        "io.vertx:vertx-stack-depchain:4.0.2",
        "io.vertx:vertx-mongo-client:4.0.2",
        "io.vertx:vertx-pg-client:4.0.2",
        "io.vertx:vertx-mysql-client:4.0.2",
        "io.vertx:vertx-junit5:4.0.2",
        "org.junit.jupiter:junit-jupiter:5.7.0"

    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)
