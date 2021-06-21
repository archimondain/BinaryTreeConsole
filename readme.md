# Purpose
It displays a binary tree on the console.

# Usage
````java
Node n = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(70)));
n.display();
````

# Algorithm
Most of the algorithms I've seen display an optimized tree in width, given that all nodes are at the same height.
This one is different : it displays all the nodes at optimum height, given that the left subtree of a node is completely at his left, and given that the right subtree of a node is completely at his right.


