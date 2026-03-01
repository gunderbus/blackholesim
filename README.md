# blackholesim JavaFX setup

## Use the project JDK in this shell

```sh
. ./scripts/enable-jdk17.sh
```

This sets:
- `JAVA_HOME=/usr/lib/sdk/openjdk17/jvm/openjdk-17`
- `PATH` to include the JDK, Maven, and Gradle binaries under `/usr/lib/sdk/openjdk17/bin`

If you use `direnv`, run:

```sh
direnv allow
```

The repo includes `.envrc` that loads the same setup automatically.

## Run the JavaFX app

```sh
. ./scripts/enable-jdk17.sh
mvn -q clean javafx:run
```

## Build

```sh
. ./scripts/enable-jdk17.sh
mvn -q clean package
```

## Notes

- This environment currently has JDK 17 available locally.
- JavaFX dependencies are resolved by Maven (`org.openjfx`).
