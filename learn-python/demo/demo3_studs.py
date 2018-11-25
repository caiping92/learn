import os


def load(path_config, db_name="studs.fdb", split="\t"):
    '''
    init students info
    :param path_config:
    :param db_name:
    :return: [[c1,c2,...],{"c1":"","c2":""},{"c1":"","c2":""},...]
    '''
    if not os.path.exists(path_config):
        os.makedirs(path_config)

    db_infos = []
    db_full_path = os.path.join(path_config, db_name)
    if os.path.exists(db_full_path):  # load info
        db = open(db_full_path, "r")
        # 首行为col_name
        cols_str = db.readline().strip()
        if cols_str == "":
            def_cols = ["Name", "Sex", "Age", "Addr", "Note"]
            db_infos.append(def_cols)
        cols = cols_str.split(split)
        cols[-1] = cols[-1].replace("\n", "")
        db_infos.append(cols)

        # 数据解析

        while True:
            data_str = db.readline().strip()
            if data_str == "":
                break
            row = data_str.split(split)
            data = {}
            for i in range(len(cols)):
                try:
                    # 最后一个元素 去掉回车
                    if i == len(cols) - 1:
                        data[cols[i]] = row[i].replace("\n", "")
                    else:
                        data[cols[i]] = row[i]

                except:
                    print("%s don't have this value " % cols[i])
                    data[cols[i]] = ""
            db_infos.append(data)
        db.close()
    else:
        def_cols = ["Name", "Sex", "Age", "Addr", "Note"]
        db_infos.append(def_cols)
    return db_infos


def flush(db_infos, path_config, db_name="studs.fdb", split="\t"):
    '''
    flush info to dfs
    saved like :
    c1  c2  c3  c4...
    vv  vv  vv

    :param path_config:
    :param db_name:
    :param split:
    :return: flush status:True / False
    '''
    if not os.path.exists(path_config):
        os.makedirs(path_config)

    db = open(os.path.join(path_config, db_name), "w")

    len_infos = len(db_infos)
    if len_infos > 1:
        clos = db_infos[0]
        if len(clos) > 1:
            db.write(split.join(clos))
            db.write("\n")

            for i in range(1, len_infos):
                for j in range(len(clos)):
                    db.write(db_infos[i][clos[j]])
                    if j != len(clos) - 1:
                        db.write(split)
                    else:
                        db.write("\n")
    db.close()
    return True


def add_row(db_infos, row):
    '''
    add row
    :param db_infos:
    :param row:
    :return: db_infos
    '''
    db_infos.append(row)
    return db_infos


def delete_by_col(db_infos, col, value):
    '''
    delete by col
    :param db_infos:
    :param col:
    :param value:
    :return: db_infos
    '''
    for i in range(1, db_infos):
        row = db_infos[i]
        if value == row[col]:
            db_infos.remove(row)
    return db_infos


def find_info_by_col(db_infos, col, value):
    result = []
    for i in range(1, len(db_infos)):
        row = db_infos[i]
        if value == row[col]:
            result.append(row)
    return result


def print_db_infos(db_infos, split="\t", width=30):
    if len(db_infos) < 1:
        print("there is nothing.")
        return
    cols = db_infos[0]
    print("-" * width)
    cols[-1] = cols[-1].replace("\n", "")
    print(split.join(cols))
    print("-" * width)
    if len(db_infos) < 2:
        print("there is no data.")
        return
    for i in range(1, len(db_infos)):
        for j in range(len(cols)):
            if j != len(cols) - 1:
                print(db_infos[i][cols[j]], end=split)
            else:
                print(db_infos[i][cols[j]], end="")
        print()


def help(width=30):
    seperator(width)
    print("Operation:")
    seperator(width)
    print("1: add student")
    print("2: delete student")
    print("3: find student")
    print("4: all student")
    print("5: alter student")
    print("6: exit system")


def seperator(width):
    print("-" * width)


def build_add_info(cols):
    '''
    {"col1::"v",..}
    :return:
    '''
    row = {}
    for col in cols:
        input_str = input(col + ":\n")
        row[col] = input_str.strip()
    return row


def build_delete_info():
    pass


def build_find_info():
    pass


def build_alter_info():
    pass


if __name__ == "__main__":
    '''
    student manager system
    '''

    width = 40

    print("*" * width)
    print("Student Manager System".center(int(width / 2)))
    print("*" * width)

    config_dir = "D:/tmp"
    db_infos = load(config_dir)
    cols = db_infos[0]

    print_db_infos(db_infos, width=width)
    print()
    help(width)

    seperator(width)
    while True:
        try:
            operator = input("Operator: \n").strip()
        except:
            print_db_infos("input %s is not a number,please check it." % operator)
            continue
        if operator == str(1):  # add
            print("input add info:")
            info = build_add_info(cols)
            if "y" == input("Are you sure add this? y is Yes \n").strip().lower():
                db_infos = add_row(db_infos, info)
                flush(db_infos, config_dir)
            else:
                print("Cancel add %s" % info)
        elif operator == str(2):
            pass
        elif operator == str(3):
            pass
        elif operator == str(4):
            print_db_infos(db_infos,width=width)
        elif operator == str(5):
            pass
        elif operator == str(6) or str(operator).lower() == "q":
            exit(0)
        else:
            print("can not support this operator %s" % operator)
