/*
Url:-https://www.geeksforgeeks.org/implement-stack-using-queue/

 Implement a Stack using two queues q1 and q2.

Solution Approach:- Swap q1 with q2 whenever q1 becomes empty
*/
class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    /*The method pop which return the element poped out of the stack*/
    int pop()
    {
        int pop=-1;
        
	    if(q1.size()==0 && q2.size()==0){
	        return -1;
	    }
	    if(q1.size()>=1){
	        while(q1.size()>1){
	            q2.add(q1.remove());
	        }
	        pop= q1.remove();
	        Queue<Integer>temp =q1;
	        q1=q2;
	        q2=temp;
	    }
	     return pop;
    }
	
    /* The method push to push element into the stack */
    void push(int a)
    {
        q1.add(a);
    }
}



