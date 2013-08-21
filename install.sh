#!/bin/bash
lein droid compile && lein droid apk && lein droid install && lein droid run && lein droid repl