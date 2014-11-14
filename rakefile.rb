#!/usr/bin/env ruby
# encoding: utf-8

require 'rubygems'
require 'bundler/setup'
require 'net/ftp'
require 'pry'

task :default => ["build"]

desc "Build"
task :build do
  clean_environment
  run_lint
  assemble
end

desc "Build & run functional tests"
task :functional_test do
  clean_environment
  run_lint
  assemble
  run_functional_test
end

def clean_environment
  run_shell("#{gradle} clean")
end

def gradle
  # gradle = (ENV['CI_BUILD'].nil?) ? "./gradlew" : "gradle"
  gradle = "./gradlew"
end

def run_lint
  run_shell "#{gradle} check"
end

def assemble
  run_shell("#{gradle} assembleDebug")
end

def run_shell(command)
  sh "#{command}"
end

def run_functional_test
  kill_appium_server_if_present
  run_shell("appium &")
  sleep 20
  run_shell("cucumber")
end

def kill_appium_server_if_present
  sh "[ -z \"$(lsof -i:4723 -t)\" ] && echo \"empty\" || kill -9 $(lsof -i:4723 -t)"
end
