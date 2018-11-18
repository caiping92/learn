# ! /usr/bin/python
import os, sys

try:
    fsock = open("D:/tmp/f1", "r")
except IOError:
    print("The file don't exist, Please double check!")
    exit()

print('The file mode is ', fsock.mode)
print('The file name is ', fsock.name)
P = fsock.tell()
print('the postion is %d' % (P))
fsock.close()

# Read file
fsock = open("D:/tmp/f1", "r")
AllLines = fsock.readlines()
# Method 1
for EachLine in fsock:
    print(EachLine)

# Method 2
print('Star' + '=' * 30)
for EachLine in AllLines:
    print(EachLine)
print('End' + '=' * 30)
fsock.close()

# write this file
fsock = open("D:/tmp/test.py", "a")
fsock.write("""
#Line 1 Just for test purpose
#Line 2 Just for test purpose
#Line 3 Just for test purpose""")
fsock.close()

# check the file status
S1 = fsock.closed
if True == S1:
    print('the file is closed')
else:
    print('The file donot close')
