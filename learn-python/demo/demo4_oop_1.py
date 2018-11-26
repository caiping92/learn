class Person():
    def __init__(self, name, age, addr):
        '''
        1.__init__ 方法在创建一个对象时，默认被调用，不需要手动调用
        2.默认与一个参数，且在第一个位置，且为：self，如果传入多个参数，则在self后面添加
        3.__init__方法中self 参数，不需要开发者传递，python解析器会把当前对象引用传递进去（原型链）

        :param name:
        :param age:
        :param addr:
        '''
        print("start init %s" % self.__class__.__name__)
        self.name = name
        self.age = age
        self.addr = addr

    def info(self):
        return "name:%s,age:%s,addr:%s" % (self.name, self.age, self.addr)

    def get_name(self):
        return self.name


def test_init():
    p = Person("caiping", 26, "zh_CN")
    print("p name is:  %s " % p.name)
    print("p get_name is:  %s " % p.get_name())
    print("P info is:  %s" % p.info())


if __name__ == "__main__":
    test_init()
