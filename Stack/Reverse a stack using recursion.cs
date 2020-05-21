/*
Url:-https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/

 Write a program to reverse a stack using recursion. 

Solution Approach:- Recurssion
*/
public class ReverseStack<T>
    {
        public static void Reverse(Stack<T> stack)
        {
            if (stack.Count == 0) return;

            var currentTop = stack.Pop();
            Reverse(stack);
            InsertAtBottom(stack, currentTop);
        }

        private static void InsertAtBottom(Stack<T> stack, T item)
        {
            if (stack.Count == 0)
            {
                stack.Push(item);
                return;
            }

            var currentTop = stack.Pop();

            InsertAtBottom(stack, item);

            stack.Push(currentTop);
        }
    }