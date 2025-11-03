#!/usr/bin/python
"""reducer.py"""

import sys

current_y = None
current_count = 0
y = None

for line in sys.stdin:
    line = line.strip()
    y, count = line.split('\t', 1)
    count = int(count)
    if current_y == y:
        current_count += count
    else:
        if current_y:
            print(str(current_y) + '\t'  + str(current_count))
        current_count = count
        current_y = y

if current_y == y:
    print(str(current_y) + '\t'  + str(current_count))