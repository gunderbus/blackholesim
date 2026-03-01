#!/bin/sh

# Project-local JDK setup for this Flatpak SDK environment.
export JAVA_HOME=/usr/lib/sdk/openjdk17/jvm/openjdk-17
export PATH="$JAVA_HOME/bin:/usr/lib/sdk/openjdk17/bin:$PATH"
