import socketserver
import optparse

import json

from conf import settings
from common.logging import get_logger
from conf.settings import status_code

log = get_logger("server")

class Response():
    def __init__(self, code, data=None):
        self.resp = {
            "code": code,
            "msg": status_code[code],
            "data": data
        }

    def json_str(self):
        return json.dumps(self.resp).encode("utf-8")

    def send(self, request):
        request.sendall(self.json_str())


class FTPHandler(socketserver.BaseRequestHandler):

    def handle(self):
        while True:
            data = self.request.recv(1024).strip()
            content = json.loads(data.decode("utf-8"))
            '''
            {
                "action":"auth",
                "data":{
                    ...
                }
            }
            '''
            action_ = content["action"]
            data_ = content["data"]
            log.info("action_: " + str(action_))
            log.info("data: " + str(data_))
            if action_ and hasattr(self, action_):
                FTPHandler.__dict__[action_](self, **data_).send(self.request)

    def auth(self, **data):
        try:
            username_ = data["username"]
        except KeyError:
            return Response("10001")
        try:
            password = data["password"]
        except KeyError:
            return Response("10002")

        log.info("auth: %s" % username_)

        return Response("0")


class Main():
    def __init__(self):



        useage = '''Usage: start-ftp-server.py -o <operation> [options] arg1 arg2 ...'''
        self.parser = optparse.OptionParser(useage)
        self.parser.add_option("-s",
                               "--server",
                               dest="server",
                               default=settings.IP,
                               help="server host")
        self.parser.add_option("-p",
                               "--port",
                               dest="port",
                               default=settings.PORT,
                               help="server port")
        cmds = filter(lambda func_name: func_name.find("__") < 0,
                      Main.__dict__)
        doc = lambda func_name: ": " + Main.__dict__[func_name].__doc__ \
            if Main.__dict__[func_name].__doc__ else ""
        oper_help = [func_name + doc(func_name).strip() for func_name in cmds]
        self.parser.add_option("-o",
                               "--operation",
                               dest="operation",
                               help=" || ".join(oper_help))
        self.options, self.args = self.parser.parse_args()
        self.__check_args()
        self.cmd(self, self.args)

    def __check_args(self):
        func_name = self.options.operation
        if not func_name:
            self.parser.print_help()
            exit(0)
        if (hasattr(self, func_name)):
            self.cmd = Main.__dict__[func_name]
        else:
            self.parser.print_help()
            exit(0)

    def start(self, *args):
        '''
        start server
        '''
        server = self.options.server
        port = self.options.port
        log.info("start server at %s:%s" % (server, port))
        tcp_server = socketserver.ThreadingTCPServer((server, port), FTPHandler)
        try:
            tcp_server.serve_forever()
        except KeyboardInterrupt as e:
            log.info("server is stop")
