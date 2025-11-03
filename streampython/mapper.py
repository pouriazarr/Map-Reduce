#!/usr/bin/python
"""mapper.py"""

import sys
for line in sys.stdin:
    line = line.strip()
    cols = line.split(";")
    y = cols[-1]
    print(y + "\t1")