from samples1 import Customer, Action
import samples1

Customer.init()
Action.init()

cust = Customer(1, 'Vasya')
act = Action('doit')

# print cust.some_data()
# print act.some_data()


def some_function():
    instance = samples1.Customer()
    return instance.get_data()