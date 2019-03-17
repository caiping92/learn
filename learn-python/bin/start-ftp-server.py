import sys, os
import optparse

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

sys.path.append(BASE_DIR)

from ftp import server

if __name__ == '__main__':
    server.Main()
