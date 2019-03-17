import logging

from logging.handlers import RotatingFileHandler

__formatter = logging.Formatter('[%(asctime)s] [%(name)s] [%(levelname)s]: %(message)s')
__level = "INFO"


def get_logger(name, console=True, level=__level):
    wrapper = LoggerWrapper(name,
                            console=console,
                            level=level,
                            formatter=__formatter)
    return wrapper.logger


class LoggerWrapper():

    def __init__(self, name, level, formatter, console=True):
        self.formatter = formatter

        self.logger = logging.getLogger(name)
        self.logger.setLevel(level)
        if console:
            self.__console()

    def __console(self):
        console = logging.StreamHandler()
        console.setFormatter(self.formatter)
        self.logger.addHandler(console)

    def rotating_file_handler(self, log_dest, maxBytes=20 * 1024 * 1024, backupCount=3):
        '''
        定义一个RotatingFileHandler，最多备份3个日志文件，每个日志文件最大20M
        :param log_dest:
        :param maxBytes:
        :param backupCount:
        :return:
        '''
        rHandler = RotatingFileHandler(log_dest, maxBytes, backupCount)
        rHandler.setFormatter(self.formatter)
        self.logger.addHandler(rHandler)
