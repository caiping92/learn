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


def content(file, mode="r"):
    with open(file) as f:
        for line in f:
            yield line


def demo1():
    '''
        r	以只读方式打开文件。文件的指针将会放在文件的开头。这是默认模式。
        w	打开一个文件只用于写入。如果该文件已存在则将其覆盖。如果该文件不存在，创建新文件。
        a	打开一个文件用于追加。如果该文件已存在，文件指针将会放在文件的结尾。也就是说，
            新的内容将会被写入到已有内容之后。如果该文件不存在，创建新文件进行写入。
        rb	以二进制格式打开一个文件用于只读。文件指针将会放在文件的开头。这是默认模式。
        wb	以二进制格式打开一个文件只用于写入。如果该文件已存在则将其覆盖。如果该文件不存在，
            创建新文件。
        ab	以二进制格式打开一个文件用于追加。如果该文件已存在，文件指针将会放在文件的结尾。
            也就是说，新的内容将会被写入到已有内容之后。如果该文件不存在，创建新文件进行写入。
        r+	打开一个文件用于读写。文件指针将会放在文件的开头。
        w+	打开一个文件用于读写。如果该文件已存在则将其覆盖。如果该文件不存在，创建新文件。
        a+	打开一个文件用于读写。如果该文件已存在，文件指针将会放在文件的结尾。
            文件打开时会是追加模式。如果该文件不存在，创建新文件用于读写。
        rb+	以二进制格式打开一个文件用于读写。文件指针将会放在文件的开头。
        wb+	以二进制格式打开一个文件用于读写。如果该文件已存在则将其覆盖。如果该文件不存在，
            创建新文件。
        ab+	以二进制格式打开一个文件用于追加。如果该文件已存在，文件指针将会放在文件的结尾。
            如果该文件不存在，创建新文件用于读写。
    '''
    path = "D:/tmp"
    filename = "f2.log"
    test2(path, filename)
    test1(path, filename)


def demo2():
    file = "D:\\tmp\\result.log"
    for line in content(file):
        print(line)


if __name__ == "__main__":
    # demo1()
    demo2()
