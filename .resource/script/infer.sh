#!/bin/bash

set -ev

INFER_VERSION=0.17.0; \
export INFER_HOME=/opt/infer-linux64-v$INFER_VERSION/bin; \
curl -sSL "https://github.com/facebook/infer/releases/download/v$INFER_VERSION/infer-linux64-v$INFER_VERSION.tar.xz" \
| sudo tar -C /opt -xJ; \
ls -l /opt/infer; \
sudo apt-get install python2.7-minimal; \
python2.7 --version;
