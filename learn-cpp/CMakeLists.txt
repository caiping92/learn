cmake_minimum_required(VERSION 3.13)
project(learn_cpp)

set(CMAKE_CXX_STANDARD 11)

include_directories(demo)

file(GLOB file_src_demo demo/*.cpp)
set(src_demo ${file_src_demo})
message(STATUS "==> demos: ${src_demo}")
add_executable(
        learn_cpp
        main.cpp
        ${src_demo}
)