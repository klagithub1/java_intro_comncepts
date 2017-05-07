*************************************
*COMP 352                           *
*Data Structures and Algorithms     *
*ASSIGNMENT 2                       *
*KLAJDI KARANXHA - 6173780          * 
*************************************

*Introduction.

Assignemnt 2 is implemented in 7 source code files:
Node.java
Cabinet.java
TestCabinet.java
Iterator.java
endOfTreeException.java
IllegalMoveException.java
IllegalTypeException.java

The General Tree data structure is implemented as a Linked List of Node objects.



*Specification of files.

Node.java
----------

Defines a class which objects represent a single node of the tree structure.
each node has a String name private instance, a Node reference to the Node parent and a reference to an array of Nodes[] 
representing the array of childs.
The list of childs should be better implemented as an ArrayList of Node objects, but for simplicity I've implemented it 
as an array which is initialized at default with 10 Node objects. As the number of childs passes this number the array gets complicated to 
operate, that is why an arraylis i suitable for this implementation.
The Node constructor takes a String to set the name of the Node, a Node object to set the parent reference, a size double to set the size of 
a file and a String to define the type of the node.
An exception is thrown if the type is file and the name contains no "." chars.

A number of get and set methods are defined also for this class.

Cabinet.java
-------------
This is the class that holds the data structure.
It has an instance variable root which is a Node that refers to the root of the tree.
root is specific and unique because its parent refers to null.
The other instance variable is a Node head. which point to the most recent Node of the structure(head node)
By manipulating it we can traverse the data structure and implement the required methods.

insert()
 takes 5 arguments, a name for the new node, the type, the size of it, parent and subparent of it to 
avoid confusion.
then it moves the head node to the define parent and accesses its array of nodes, and the first empty node encountered in the array
is assigned to the new node with the given parameters which points to the specified parent.

copy()
 traverses the tree till it goes to the specified node. copies the node to a temporary Node
traverses the tree again to the new location and accesses the array of childs of the new Node location, the first empty Node in the array is assigned
to the temporary node.
Then the array of childs is accessed and all the childs are made to point at the new parent.

display()
goes through every element in the array and displays it.
could be better implemented with a foreach loop.

cut()
acts same as copy() but instead the array of childs of the old node to be moved is made point to null and the old node is made top point to null.

rename()
takes a string argument for the new name, another for the node to rename and another for its subparent to avoid confusion.
Then it moves the pointer to the node and renames it.

remove()
moves pointer to the node and makes all its child Nodes point to the subParent and the current parent point to null. by deleting it.

space()
adds up all teh space doubles of the fiel Nodes.

count()
returns the node counter.
or there is another version that initializes a counter and traverses all the tree by incerementing the counter as many times
as a nonempty node is found .
I have a bug, while i use cut to cut a node and all subnodes I incerement count only once and the noedCount counter losses accuracy.


height()
traverses all the tree levels of the  linked structure by incrementing an internal count.


iterator()
 returns a new iterator() object.
 
*Exception.java
-----------------
Are the three classes that handel different (but not all!) the exceptions that can be encountered during operations.


Iterator.java
----------------
has two Node references that are manipulated as pointers that move through the data structure.

Node previous and node Position.

in the method move()
position moves to the parent and previous move to its parent by moving one level in the tree 
in the method hasNext()
if the position.parentNode is pointing at null means that tree has reached root else it returns true.
remove()
iterates through the tree and wherever encounters the node name we wanna remove it makes its child point ot null and delete every reference to this node,
where no pointer is associated to it then it goes automatically to automatic garbage collector.

TestCabinet.java
------------------

Is the class that test the data structure.
Unfortunately during my implemetation I couldn't implement the correct testing class as I have some bugs in
some of the methods such as display() and move() that do not give a realist testing of the linked structure.

For partial points I've enclosed in TestIterator.java
the way to chomp a user input address and take out the String of parent and Subparent name to operate the methods.
useing the method useDelimiter(arg0);



Other Notations
-----------------

I found most of the difficulties in implementing the Cabinet class
and the Iterator class which are subsequently related to difficulties in implmenting the TestCabinet Class.

****************************************************************************************************************

Thank You for considering the time to look at my code.

****************************************************************************************************************


 