import time as t


def main():
    b=[2,3,5,1,4]
    a = [ 4, 6, 3, 34,8,5,8,865, 1,556,84,8]


    def swap(x,y):
        t=a[x]
        a[x]=a[y]
        a[y]=t

    def partition(a,p,r):
        x=a[r]
        j=p-1
        for i in xrange(p,r):
            if a[i]<=x:
                j=j+1
                swap(i,j)
        swap(j+1,r)
        return j+1




    def quickSort(a, p,r):
        if p < r:
            q=partition(a,p,r)
            quickSort(a,p,q-1)
            quickSort(a,q+1,r)

    print a
    quickSort(a, 0, len(a)-1)
    print a

if __name__ == "__main__":
    main()

"""
Reference : 
Introduction to Algorithms - 3RD edition
http://www.python-course.eu/passing_arguments.php
"""
