public class Node
{
    //Max order is 4.
    private static final int ORDER = 4;

    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private NodeData itemArray[] = new NodeData[ORDER-1];

    public Node()
    {

    }

    //Connect child node to give node.
    public void connectChild(int childNum, Node child)
    {
        childArray[childNum] = child;
        if(child != null)
            child.parent = this;
    }

    //Disconnect child node from given node.
    public Node disconnectChild(int childNum)
    {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    //Method returns a child from the child array.
    public Node getChild(int childNum)
    {
        return childArray[childNum];
    }

    //Method returns a parent node.
    public Node getParent()
    {
        return parent;
    }

    //Method returns a Leaf Node.
    public boolean isLeaf()
    {
        return (childArray[0]==null) ? true : false;
    }

    //Method returns the number of items.
    public int getNumItems()
    {
        return numItems;
    }

    //Method returns the node data at the given index.
    public NodeData getItem(int index)
    {
        return itemArray[index];
    }

    //Method determins if array is full. If so
    //return true. If the array in not full, return false.
    public boolean isFull()
    {
        if (numItems == ORDER-1)
        {
            return true;
        }
        else
            return false;
    }

    //Method determine if a given number is in the node.
    //If it does exists, return position. if not return -1;
    public int findItem(double x)
    {
        for(int i=0; i<ORDER-1; i++)
        {
            if(itemArray[i] == null)
            {
                break;
            }
            else if(itemArray[i].data == x)
                return i;
        }
        return -1;
    }

    //Method inserts given node data into node.
    public int insertItem(NodeData newItem)
    {

        //Increment number of items in node.
        numItems++;

        //Declare key of the new item.
        double newKey = newItem.data;

        //
        for(int j=ORDER-2; j>=0; j--)
        {
            if(itemArray[j] == null)
            {
                continue;
            }
            else
            {
                double itsKey = itemArray[j].data;
                if(newKey < itsKey)
                {
                    itemArray[j + 1] = itemArray[j];
                }
                else
                {
                    itemArray[j+1] = newItem;
                    return j+1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }


}
