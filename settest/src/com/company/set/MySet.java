package com.company.set;


import com.company.tree.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;


/**
 * Created by dima on 15.05.17.
 */
public class MySet implements AnalogSet, Iterable {

    private Node root;
    private int counter;

    @Override
    public boolean add(String value) {
        if (!contains(value)) {
            counter++;
            root = add(value, root);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String value) {

        root = remove(root, value);
        if (root != null) {
            counter--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(String value) {
        return contains(root, value);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return counter;
    }

    private int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    public int getHeightTree() {
        return maxDepth(root);
    }


    private int height(Node root) {
        return root == null ? -1 : root.height;
    }


    private Node add(String value, Node root) {
        if (root == null)
            root = new Node(value);
        else if (value.compareTo(root.value) < 0) {
            root.left = add(value, root.left);

            if (height(root.left) - height(root.right) == 2) {
                if (value.compareTo(root.left.value) < 0) {
                    root = rotateWithLeftChild(root);

                } else {
                    root = doubleWithLeftChild(root);

                }
            }
        } else if (value.compareTo(root.value) > 0) {
            root.right = add(value, root.right);

            if (height(root.right) - height(root.left) == 2)
                if (value.compareTo(root.right.value) > 0) {
                    root = rotateWithRightChild(root);

                } else {
                    root = doubleWithRightChild(root);

                }
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }

    private Node rotateWithLeftChild(Node root1) {
        Node root2 = root1.left;
        root1.left = root2.right;
        root2.right = root1;
        root1.height = Math.max(height(root1.left), height(root1.right)) + 1;
        root2.height = Math.max(height(root2.left), root1.height) + 1;
        return root2;
    }


    private Node rotateWithRightChild(Node root1) {
        Node root2 = root1.right;
        root1.right = root2.left;
        root2.left = root1;
        root1.height = Math.max(height(root1.left), height(root1.right)) + 1;
        root2.height = Math.max(height(root2.right), root1.height) + 1;
        return root2;
    }

    private Node doubleWithLeftChild(Node root) {
        root.left = rotateWithRightChild(root.left);
        return rotateWithLeftChild(root);
    }

    private Node doubleWithRightChild(Node root) {
        root.right = rotateWithLeftChild(root.right);
        return rotateWithRightChild(root);
    }


    private Node findMax(Node t) {
        if (t == null)
            return t;

        while (t.right != null)
            t = t.right;
        return t;
    }

    private Node remove(Node root, String value) {
        if (root == null) {
            return null;
        }

        if (value.compareTo(root.value) < 0) {
            root.left = remove(root.left, value);
            int l = root.left != null ? root.left.height : 0;

            if ((root.right != null) && (root.right.height - l >= 2)) {
                int rightHeight = root.right.right != null ? root.right.right.height : 0;
                int leftHeight = root.right.left != null ? root.right.left.height : 0;

                if (rightHeight >= leftHeight)
                    root = rotateWithLeftChild(root);
                else
                    root = doubleWithRightChild(root);
            }
        } else if (value.compareTo(root.value) > 0) {
            root.right = remove(root.right, value);
            int r = root.right != null ? root.right.height : 0;
            if ((root.left != null) && (root.left.height - r >= 2)) {
                int leftHeight = root.left.left != null ? root.left.left.height : 0;
                int rightHeight = root.left.right != null ? root.left.right.height : 0;
                if (leftHeight >= rightHeight)
                    root = rotateWithRightChild(root);
                else
                    root = doubleWithLeftChild(root);
            }
        } else if (root.left != null) {
            root.value = findMax(root.left).value;
            remove(root.left, root.value);

            if ((root.right != null) && (root.right.height - root.left.height >= 2)) {
                int rightHeight = root.right.right != null ? root.right.right.height : 0;
                int leftHeight = root.right.left != null ? root.right.left.height : 0;

                if (rightHeight >= leftHeight)
                    root = rotateWithLeftChild(root);
                else
                    root = doubleWithRightChild(root);
            }
        } else
            root = (root.left != null) ? root.left : root.right;

        if (root != null) {
            int leftHeight = root.left != null ? root.left.height : 0;
            int rightHeight = root.right != null ? root.right.height : 0;
            root.height = Math.max(leftHeight, rightHeight) + 1;
        }
        return root;
    }

    private boolean contains(Node root, String value) {
        if (root == null) {
            return false;

        } else if (value.compareTo(root.value) < 0) {
            return contains(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            return contains(root.right, value);
        }

        return true;
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            TreeIterator treeIterator = new TreeIterator(root);

            @Override
            public boolean hasNext() {
                return treeIterator.hasNext();
            }

            @Override
            public String next() {
                return treeIterator.next();
            }
        };
    }


    public class TreeIterator implements Iterator {
        Stack<Node> stack = new Stack<>();


        private void pushLeftChildren(Node current) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }


        TreeIterator(Node root) {
            pushLeftChildren(root);
        }


        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }


        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("All nodes have been visited!");
            }

            Node res = stack.pop();
            pushLeftChildren(res.right);

            return res.value;
        }
    }
}
