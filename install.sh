#!/bin/bash
lein droid build && lein droid apk && lein droid install && lein droid run && lein droid repl
