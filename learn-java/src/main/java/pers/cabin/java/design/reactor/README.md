
## 参考：
 http://blog.csdn.net/u010168160/article/details/53019039
 http://blog.csdn.net/pistolove/article/details/53152708
 https://www.cnblogs.com/f1194361820/p/5679796.html
 
    反应器模式
    用于解决多用户访问并发问题
 
##举个例子
    
    餐厅服务问题
    传统线程池做法：来一个客人(请求)去一个服务员(线程)
    反应器模式做法：当客人点菜的时候，服务员就可以去招呼其他客人了，等客人点好了菜，直接招呼一声“服务员”
 
