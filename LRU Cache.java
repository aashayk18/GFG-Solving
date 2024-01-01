class Node
{
    int key,value;
    Node prev, next;
    
    Node(int k, int v)
    {
        key = k;
        value = v;
    }
}
class LRUCache
{
    private static HashMap<Integer, Node> m;
    private static int capacity, count;
    private static Node head;
    private static Node tail;
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        m = new HashMap<>();
        capacity = cap;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.prev = null;
        count = 0;
    }
    private static void deleteNode(Node temp)
    {
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
    }
    private static void addToHead(Node temp)
    {
        temp.next = head.next;
        head.next.prev = temp;
        temp.prev = head;
        head.next = temp;
    }
    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        if(m.get(key)!=null)
        {
            Node temp = m.get(key);
            int result = temp.value;
            deleteNode(temp);
            addToHead(temp);
            return result;
        }
        return -1;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        if(m.get(key)!=null)
        {
            Node temp = m.get(key);
            temp.value = value;
            deleteNode(temp);
            addToHead(temp);
        }
        else
        {
            Node new_ = new Node(key, value);
            m.put(key, new_);
            if(count<capacity)
            {
                count++;
                addToHead(new_);
            }
            else
            {
                m.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(new_);
            }
        }
    }
}
