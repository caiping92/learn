import sys, os

BASE_DIR = os.path.dirname(os.path.dirname(__file__))
sys.path.append(BASE_DIR)


def test():
    from demo import demo4_oop_1
    demo4_oop_1.test_init()
    print(BASE_DIR)


if __name__ == "__main__":
    test()
