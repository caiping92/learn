import sys, os

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
sys.path.append(BASE_DIR)

import socket
import optparse
from common.logging import get_logger
import json

log = get_logger("client")

def render_in(self, *args):
    print("[in]: " + " ".join(args))


def render_out(self, *args):
    print("[out]: " + " ".join(args))


class Request():

    def __init__(self, action, data):
        self.req = {
            "action": action,
            "data": data
        }

    def json_str(self):
        return json.dumps(self.req).encode("utf-8")

    def send(self, socket):
        socket.sendall(self.json_str())


class Handler():

    def put(self, *args):
        print(args)
        if len(args) == 0:
            raise RuntimeError("put src dst")
        # render_out("start put %s"%" ".join(args))
        render_out("start put %")


class Client():

    def __init__(self):
        self.parser = optparse.OptionParser()
        self.parser.add_option("-s", "--server", dest="server", help="connect server", default="127.0.0.1")
        self.parser.add_option("-P", "--port", dest="port", help="connect port", default=80)
        self.parser.add_option("-u", "--username", dest="username", help="connect user", default="root")
        self.parser.add_option("-p", "--password", dest="password", help="connect password", default="root")

        self.options, self.args = self.parser.parse_args()

        self.verify_args()

        self.handler = Handler()

    def verify_args(self):
        self.server = self.options.server
        self.port = self.options.port
        self.username = self.options.username
        self.password = self.options.password
        if self.port > 0 and self.port < 65535:
            return True
        else:
            log.info("%s is not between 0 and 65535" % str(self.port))
            return False

    def make_connect(self):
        self.socket = socket.socket()
        self.socket.connect((self.server, self.port))

    def interactive(self):
        # 认证
        authentication_res = self.authentication()
        log.info(authentication_res)
        code_ = authentication_res["code"]
        if code_ == "0":
            print("login success")
            self.run()
        else:
            print(authentication_res["msg"])

    def run(self):
        while True:
            cmd_args = input("%s #: " % self.username).strip()
            cargs = cmd_args.split(" ")
            try:
                self.parse(*cargs)
            except RuntimeError as e:
                print(e.__cause__)

    def parse(self, *args):
        if len(args) == 0:
            return
        if args[0] == '':
            return
        operation = args[0]

        render_in(" ".join(args))
        if operation.lower() == "q":
            self.socket.close()
            exit(0)
        elif hasattr(Handler, operation):
            try:
                Handler.__dict__[operation](self.handler, *args[1:])
            except Exception as e:
                print(e.__cause__)
        else:
            render_out("`%s`not support not!" % operation)
            self.help()

    def help(self):
        pass

    def authentication(self):

        if self.username is None or self.password is None:
            self.username = input("username: ").strip()
            self.password = input("password: ").strip()
            return self.login()
        return self.login()

    def login(self):
        log.info("login ...")
        req = {
            "username": self.username,
            "password": self.password
        }
        Request("auth", req).send(self.socket)
        return self.response()

    def response(self):
        decode = self.socket.recv(1024).decode("utf-8")
        return json.loads(decode)


if __name__ == '__main__':
    # s = socket.socket()
    # s.connect(("127.0.0.1", 80))
    #
    # content ={
    #     "action": "auth",
    #     "data":{
    #         "username": "root",
    #         "password": "root"
    #     }
    # }
    # s.send(json.dumps(content).encode("utf-8"))

    client = Client()
    client.make_connect()
    client.interactive()
