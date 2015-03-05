
# ======================================
# * = tuple
# ======================================


def f(a, b, c):
    print "f(a,b,c): ", a, b, c

print "calling f(1,2,3)"
f(1,2,3)

print "calling f(*[4,5,6])"
l = [4,5,6]
f(*l)

print "--------------------"

def fun(a, *args):
    print "fun(a,*args): a is", a
    print "fun(a,*args): args is", args


fun(1,2,3,4)

print "--------------------"

def calc_sum(*args):
    print "     calc_sum(*args): ", args
    return sum(args)

def my_sum(name, *args):
    print "   my_sum(name,*args):", name, args
    s = calc_sum(*args)
    print "   sum=", s

print "calling: my_sum('boss', 1,2,3)"
my_sum("boss", 1,2,3)

# ======================================
# ** = dictionary
# ======================================

d = {'b': 222, 'c':333}

def fun1(a,b,c):
    print a,b,c

fun1(1, **d)

# --------------------

def fun2(a, **kwargs):
    print "fun2(a, **kwargs)"
    print "a is", a
    print "We expect kwargs 'b' and 'c' in this function"
    print "b is", kwargs['b']
    print "c is", kwargs['c']

fun2(1, b=4, c=5)

fun2(2, b=6, c=7, d=8)

fun2(111, **d)
