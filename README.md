Backport9
=========

A collection of backports and utilities to support libraries and apps that
want to use Java 9 features but still function on Java 8.

Modules
-------

A light shim library that wraps Java 9 and previous reflection APIs to allow a
uniform API into "module"-like behaviors on all recent JDKs.

Buffers
-------

Binary-compatible calling shims for java.nio.Buffer and subclasses.

Stack
-----

A look-alike wrapper around the Java 9 StackWalker API with Java 8 support.
