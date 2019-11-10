# -*- coding: utf-8 -*-
import scrapy


class MvcatSpider(scrapy.Spider):
    name = 'mvcat'
    allowed_domains = ['www.mvcat.com/']
    start_urls = ['http://www.mvcat.com//']

    def parse(self, response):
        pass
