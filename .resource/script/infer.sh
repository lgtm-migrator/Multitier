#!/bin/bash

set -ev

INFER_VERSION=0.17.0; \
export INFER_HOME=/infer/infer-linux64-v$INFER_VERSION/bin; \
curl -sSL "https://github.com/facebook/infer/releases/download/v$INFER_VERSION/infer-linux64-v$INFER_VERSION.tar.xz" \
| sudo tar -C /infer -xJ && ls -l /infer
