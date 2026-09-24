class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    // we move all the elements from first stake to another, then take the element from second stake.
    // just like sort games
    public int pop() {
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        int num = second.pop();
        while (!second.isEmpty()){
            first.push(second.pop());
        }
        return num;
    }
    // we do similar thing with peek.
    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int peeked = second.peek();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return peeked;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}
