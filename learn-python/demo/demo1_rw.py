import os, sys


def test1(path, filename="f1"):
    if not os.path.exists(path):
        os.makedirs(path)
    try:
        file = os.path.join(path, filename)
        fsock = open(file, "r")
    except IOError:
        print("The file don't exist, Please double check!")
        exit()

    print('The file mode is ', fsock.mode)
    print('The file name is ', fsock.name)
    P = fsock.tell()
    print('the postion is %d' % (P))
    fsock.close()

    # Read file
    fsock = open(file, "r")
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


def test2(path, filename="f1"):
    if not os.path.exists(path):
        os.makedirs(path)
    file = os.path.join(path, filename)
    # write this file
    fsock = open(file, "a")
    fsock.write("""
    #Line 1 Just for test purpose
    #Line 2 Just for test purpose
    #Line 3 Just for test purpose""")
    fsock.close()

    # check the file status
    res = fsock.closed
    if True == res:
        print('the file is closed')
    else:
        print('The file donot close')

if __name__ == "__main__":
    path = "D:/tmp"
    filename="f2.log"
    test2(path,filename)
    test1(path,filename)
