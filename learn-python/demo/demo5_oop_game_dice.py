import random


class Player():
    def __init__(self,name,sex,*dices):
        self.name=name
        self.sex=sex
        self.dices=dices#元组

    def cast(self):
        '''
        扔骰子
        :return:
        '''
        points=[]
        for dice in  self.dices:
            points.append(dice.dance())

    def result(self):
        '''
        玩家输赢
        :return:
        '''
        pass

    def say(self,*points):
        '''
        玩家猜点数
        :return:
        '''
        return points

class Dice():

    def __int__(self,count):
        '''
        :param count:
        :return:
        '''
        self.count=count

    def dance(self):
        '''
        骰子摇动
        :return: point
        '''
        pass
        return random.randint(1,6)

class DiceGame():
    def __int__(self,*players):
        self.players=players
        print("Dice Game is inited.")

    def start(self):
        for player in self.players:
            pass
            

    def guess(self):
        pass
    def winner(self):
        '''
        谁赢
        :return:
        '''
        pass
    def detail(self):
        '''
        游戏结果详情
        :return:
        '''
        pass
    def description(self):
        '''
        游戏规则
        :return:
        '''
        pass