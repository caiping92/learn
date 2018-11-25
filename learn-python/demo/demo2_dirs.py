import sys, os


def get_os_info():
    print("Path: %s" % sys.path)
    print("Platform: %s" % sys.platform)


def get_files(path):
    files = []
    if os.path.isfile(path):
        files.append(path)
    else:
        dirs = os.listdir(path)
        for dir in dirs:
            files += get_files(os.path.join(path, dir))
    return files


def get_dirs(path):
    dirs = []
    if os.path.isdir(path):
        dirs.append(path)
        for f in os.listdir(path):
            full_path = os.path.join(path, f)
            if os.path.isdir(full_path):
                dirs += get_dirs(full_path)
    return dirs


def result(path="D:/tmp", filename="result.log"):
    if not os.path.exists(path):
        os.makedirs(path)
    dist = os.path.join(path, filename)
    fs = open(dist, "w")
    return fs


if __name__ == "__main__":
    print("-" * 30)

    get_os_info()
    print("-" * 30)

    tmp = "E:/workspace"
    print("Start get %s info ...\n " % tmp)

    fs = result()
    fs.write("-" * 30 + "\n")

    dirs = get_dirs(tmp)
    files = get_files(tmp)

    fs.write(tmp + " all files(%s): \n" % len(files))
    fs.write(tmp + " all dirs(%s):\n" % len(dirs))
    fs.write("-" * 30 + "\n")

    fs.write("\n".join(files))
    fs.write("\n" + "-" * 30 + "\n")

    fs.write(">" * 15 + "<" * 15 + "\n")
    fs.write("<" * 15 + ">" * 15 + "\n")
    fs.write(">" * 15 + "<" * 15 + "\n")

    fs.write("\n".join(dirs))
    fs.write("\n" + "-" * 30 + "\n")

    if fs.close():
        print("Get result successful.")
    else:
        print("Get result unsuccessful.")
