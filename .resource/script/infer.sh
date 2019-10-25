#!/bin/bash

set -ev

# Make a folder for Infer:
mkdir ${HOME}/infer

# Download last Infer:
curl -sSL "https://github.com/facebook/infer/releases/download/v${INFER_VERSION}/infer-linux64-v${INFER_VERSION}.tar.xz" \
	| sudo tar -C ${HOME}/infer -xJ

# Install Python v2.7 (required by Infer):
sudo apt-get install python2.7-minimal
python2.7 --version
