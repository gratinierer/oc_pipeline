#!/bin/bash
curl -X 'POST' \
  'http://gitea-http:3000/api/v1/user/repos' \
  -H 'accept: application/json' \
  -H 'authorization: Basic Z2l0ZWFfYWRtaW46cjhzQThDUEhEOSFidDZk' \
  -H 'Content-Type: application/json' \
  -d '{
  "auto_init": true,
  "default_branch": "main",
  "description": "sandbox-branch",
  "name": "sandbox",
  "private": false,
  "readme": "Default",
  "template": false,
  "trust_model": "default"
}'