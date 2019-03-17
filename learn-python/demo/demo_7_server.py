#!/usr/bin/env python
# -*- coding:utf-8 -*-

import socket

def start(ip_port):
    sk = socket.socket()
    sk.bind(ip_port)
    sk.listen(5)
    while True:
        print 'server waiting...'
        conn, addr = sk.accept()

        client_data = conn.recv(1024)
        print client_data
        conn.sendall('this is a msg from server.')

        conn.close()

if __name__ == "__main__":
    start(ip_port = ('127.0.0.1',9999))

