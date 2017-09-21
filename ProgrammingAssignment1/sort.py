import time as t

def main():

    def insertionSort(alist):
        """
        :param alist: List to implement Insertion sort
        """
        for i in xrange(1,len(alist)):
            key=alist[i]
            j=i-1
            while j>=0 and alist[j]>key:
                alist[j+1]=alist[j]
                j=j-1
            alist[j+1]=key


    def bubbleSort(lista):
        """
        :param lista: List to implement Bubble sort
        :return:
        """
        for i in xrange(0,len(lista),1):
            for j in xrange(len(lista)-1,i,-1):
                if lista[j-1]>lista[j]:
                    temp=lista[j-1]
                    lista[j-1]=lista[j]
                    lista[j]=temp


    for m in ["I","R","D"]:    #Loop all three sets of files
        for i in xrange(1,13):
            fl = open("{0}{1}.txt".format(m,i), "r")
            lst = []
            a = 0.0
            b = 0.0
            if m == "R":
                sampling = 10 #Setting avg time calculation  for Random input
            else:
                sampling = 1
            for line in fl:
                lst.append(int(line.strip()))
            count=len(lst)
            for j in xrange(1, sampling+1):
                avg=j
                start = t.time()
                insertionSort(lst)  #Invoke insertion sort
                end = t.time()
                a=a+(end-start)
                start = t.time()
                bubbleSort(lst)     #Invoke bubble sort
                end = t.time()
                b = b+(end - start)
            print "{0}{1}".format(m,i),"Insertion",count,a/avg
            print "{0}{1}".format(m,i),"Bubble   ",count,b/avg
            fl.close()

if __name__ == "__main__":
    main()


"""
Reference : 
Introduction to Algorithms - 3RD edition
http://www.python-course.eu/passing_arguments.php
"""