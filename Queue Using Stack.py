#User function Template for python3

class Queue:
    def __init__(self):
        self.stack1=[]
        self.stack2=[]
        
    def enqueue(self,X):
        self.stack1.append(X)
        
    def dequeue(self):
        if len(self.stack1)==0: # there are no elements in stack
            return -1 
            
        if len(self.stack2)!=0: 
            temp=self.stack2[-1]
            self.stack2.pop()
            return temp
            
        while len(self.stack1)!=0:
            self.stack2.append(self.stack1[-1])
            self.stack1.pop()
        
        temp=self.stack2[-1]
        self.stack2.pop()
        return temp


#{ 
 # Driver Code Starts
if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases) :
        ob=Queue()
        n = int(input())
        a = list(map(int,input().strip().split()))
        i = 0
        while i<len(a):
            if a[i] == 1:
                ob.enqueue(a[i+1])
                i+=1
            else:
                print(ob.dequeue(),end=" ")
            i+=1

        print()
# } Driver Code Ends
