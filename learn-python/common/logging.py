import logging

from logging.handlers import RotatingFileHandler

'''
 %(name)s            Name of the logger (logging channel)
    %(levelno)s         Numeric logging level for the message (DEBUG, INFO,
                        WARNING, ERROR, CRITICAL)
    %(levelname)s       Text logging level for the message ("DEBUG", "INFO",
                        "WARNING", "ERROR", "CRITICAL")
    %(pathname)s        Full pathname of the source file where the logging
                        call was issued (if available)
    %(filename)s        Filename portion of pathname
    %(module)s          Module (name portion of filename)
    %(lineno)d          Source line number where the logging call was issued
                        (if available)
    %(funcName)s        Function name
    %(created)f         Time when the LogRecord was created (time.time()
                        return value)
    %(asctime)s         Textual time when the LogRecord was created
    %(msecs)d           Millisecond portion of the creation time
    %(relativeCreated)d Time in milliseconds when the LogRecord was created,
                        relative to the time the logging module was loaded
                        (typically at application startup time)
    %(thread)d          Thread ID (if available)
    %(threadName)s      Thread name (if available)
    %(process)d         Process ID (if available)
    %(message)s         The result of record.getMessage(), computed just as
                        the record is emitted
'''

__formatter = logging.Formatter(
    '[%(process)d:%(threadName)s] [%(asctime)s] [%(levelname)s] [%(name)s:%(lineno)d]: %(message)s')
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
