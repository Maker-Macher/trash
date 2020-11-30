import random
import re
import time

zahlen = ''

for i in range(10):
    zahlen += str(i) 
    
lul = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
lul2 = ['#','!','%','?','€','$','*', '=']
word = 'Es war einmal in einer HBIT Klasse als der Viktor einfach das was Justin programmierte in 2 Tagen gefühlt in 5 min geschrieben hat und ihn komplett damit depressiv gemacht hat da er seine lebenszeit damals verschwenndet hatte'
obscured = ''

##for i in range(10):
##    print(lul[random.randint(0,len(lul))])

for i in range(len(word)):
    obscured += lul[random.randint(0,len(lul) - 1)]

print(obscured)
##
##o = obscured[:0] + word[0] + obscured[1:]
##print(o)


def unobscure():
    global obscured
    for i in range(len(obscured)):
        obscured = obscured.replace(obscured[i],word[i], 1)
        print(obscured)
        print('\n')
        time.sleep(random.randint(1,5) / 50)

time.sleep(3)
unobscure()
