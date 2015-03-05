import time
import random

class Customer:

    _some_data = None

    def __init__(self, id, name):
        self.name = name
        self.id = id

    def get_name(self):
        return self.name

    def get_id(self):
        return self.id

    def get_data(self):
        return Customer._some_data

    def my_method(self, arg1, arg2):
        t1 = time()
        time.sleep(random.randint(1,3))
        t2 = time()
        return arg1 + arg2 + t1 + t2

    @staticmethod
    def init():
        Customer._some_data = [1,2,3]


class Action:

    _action_data = None

    def __init__(self, action):
        self.action = action

    def get_data(self):
        return Action._action_data

    @classmethod
    def init(cls):
        Action._action_data = ['a', 'b', 'c']


class ProductionClass:
    def closer(self, something):
        something.close()


my_module_attribute = "XOXO"