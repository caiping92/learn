import sys, os

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
DIR_CONF = os.path.join(BASE_DIR, "conf")

IP = "127.0.0.1"
PORT = 80

status_code = {
    "0": "success",
    "1": "fail",

    "10001": "username can not be null",
    "10002": "password can not be null"

}
