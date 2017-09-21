import time as t


def main():
    a = [14, 4, 6, 3, 0, 84,7,8]
    print a

    def merge(a,s,l,e):
        left=a[s:l+1]
        right=a[l+1:e+1]
        i=0
        j=0
        print a
        for k in xrange(s,e):
                if left[i]<=right[j]:
                    a[k]=left[i]
                    a[k+1]=right[j]
                    i=i+1
                else:
                    a[k]=right[j]
                    a[k+1]=left[i]
                    j=j+1
        #print a



    def mergeSort(a, s, e):
        if s < e:
            length = (e+s) / 2
            mergeSort(a, s, length)
            mergeSort(a, length+1, e)
            merge(a,s,length,e)


    mergeSort(a, 0, len(a)-1)


if __name__ == "__main__":
    main()

"""
Reference : 
Introduction to Algorithms - 3RD edition
http://www.python-course.eu/passing_arguments.php
"""
