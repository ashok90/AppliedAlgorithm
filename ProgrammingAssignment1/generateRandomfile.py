
import random as r


def main():

    # Function to generate Random integer Numbers
    def generateRandom(x,y):
        """
        :param x: no of records
        :param y: file naming convention
        :return:
        """
        dfile = open("R%s.txt" %y, "a+")
        for i in xrange(x):
            data=r.randint(1,99999)
            dfile.write(str(data)+'\n')
        dfile.close()

    # Function to generate Random integer Numbers in ascending order
    def generateIncremental(x,y):
        """
        :param x: no of records
        :param y: file naming convention
        :return:
        """
        dfile = open("I%s.txt" %y, "a+")

        a=1
        for i in xrange(1,x+1):
            data = r.randint(a, a+5)   #Random numbers generated in a incremental batch of 5
            dfile.write(str(data) + '\n')
            a=a+5
        dfile.close()

    # Function to generate Random integer Numbers in descending order
    def generateDecremental(x, y):
        """
        :param x: no of records
        :param y: file naming convention
        :return:
        """
        dfile = open("D%s.txt" % y, "a+")
        a = x*10
        for i in xrange(1, x + 1):
            data = r.randint(a-5,a)    #Random numbers generated in a decremental batch of 5
            dfile.write(str(data) + '\n')
            a = a - 5
        dfile.close()

    a=1
    for i in xrange(2000,26000,2000):
        print i,a
        generateRandom(i,a)
        generateDecremental(i,a)
        generateIncremental(i,a)
        a=a+1

if __name__=="__main__":
    main()

#this program generates 3 independent sets of file with different record count(2000-24000)
#       1.R*.txt -> Random numbers x1,x2...xn
#       2.I*.txt -> Random numbers in increasing order x1,x2...xn where x1<=x2...<=xn
#       2.D*.txt -> Random numbers in increasing order x1,x2...xn where x1>=x2...>=xn