#!/usr/bin/env python
# -*- coding:utf-8 -*-
import socket

def send(ip_port):
    sk = socket.socket()
    sk.connect(ip_port)
    sk.sendall('hello from client')
    server_reply = sk.recv(1024)
    print server_reply
    sk.close()

if __name__ == '__main__':
    ip_port = ('127.0.0.1',9999)
    send(ip_port)