import glob
import os
output = os.getenv('OUTPUT').split('/')[-1]
files = glob.glob('/tmp/salesdataoutput/' + output + '/part*')
for f in files:
    with open(f, 'rb') as of:
        print(of.readlines())