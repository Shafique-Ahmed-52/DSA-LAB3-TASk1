package com.mycompany.singlylinkedlist;

public class SinglyLinkedlist {
    
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    SinglyLinkedlist() {
        this.head = null;
    }

    
    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

 
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

   
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            insertAtStart(data);
        } else {
            Node current = head;
            for (int i = 0; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            if (current != null) {
                newNode.next = current.next;
                current.next = newNode;
            } else {
                System.out.println("Position out of bounds.");
            }
        }
    }

    
    public void deleteFromStart() {
        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            head = head.next;
        }
    }

   
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("The list is empty.");
        } else if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }

 
    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("The list is empty.");
        } else if (head.data == data) {
            head = head.next;
        } else {
            Node current = head;
            while (current.next != null && current.next.data != data) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            } else {
                System.out.println("Value not found.");
            }
        }
    }

   
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    
    public void search(int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Value " + value + " found at position " + index);
                return;
            }
            current = current.next;
            index++;
        }
        System.out.println("Value not found.");
    }

    
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public static void main(String[] args) {
        SinglyLinkedlist list = new SinglyLinkedlist();
        list.insertAtStart(10);
        list.insertAtStart(20);
        list.insertAtStart(30);
        list.insertAtStart(40);
        
        list.insertAtEnd(50);

        list.insertAtPosition(25, 2);
        
        System.out.println("List after insertions:");
        list.display();
        
        list.search(25);
        list.search(100);
        
        list.deleteFromStart();
        System.out.println("List after deleting from start:");
        list.display();
        
        list.deleteFromEnd();
        System.out.println("List after deleting from end:");
        list.display();
        
        list.deleteByValue(30);
        System.out.println("List after deleting value 30:");
        list.display();
        
        list.reverse();
        System.out.println("List after reversing:");
        list.display();
        
        int count = list.countNodes();
        System.out.println("Number of nodes in the list: " + count);
    }
}
