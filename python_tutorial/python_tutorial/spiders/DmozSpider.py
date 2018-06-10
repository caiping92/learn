import scrapy
import sys
import os

class DmozSpider(scrapy.Spider):
    name = "dmoz"
    allowed_domains = ["dmoz.org"]
    start_urls = [
        "http://www.dmoz.org/Computers/Programming/Languages/Python/Books/",
        "http://www.dmoz.org/Computers/Programming/Languages/Python/Resources/",
        "https://www.csdn.net/"
    ]

    def parse(self, response):

        filePath = "D:/tmp/scrapy/"
        exists = os.path.exists(filePath)
        if  not exists:
            os.makedirs(filePath)
        filename = filePath+(response.url.split("/")[-2])
        # print(response.url.split("/"))
        # filename = response.url.split("/")[-2]
        with open(filename, 'wb') as f:
            f.write(response.body)

