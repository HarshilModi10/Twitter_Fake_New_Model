#!/bin/bash

# Use FFMPEG to generate MP4
ffmpeg -framerate 1 -pattern_type glob -i '*.png'   -c:v libx264 -r 30 -pix_fmt yuv420p out.mp4