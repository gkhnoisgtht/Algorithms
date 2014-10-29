/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.data_structures;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * @author DJ
 * @param <k>
 */
public class LinkedList<k> implements Iterable<k> {

    @Override
    public Iterator<k> iterator() {
        return new ListIterator<k>() {
            private Node<k> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public k next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<k> item = current;
                current = current.next;
                return item.data;
            }

            @Override
            public boolean hasPrevious() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public k previous() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set(k e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(k e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

    private class Node<k> {

        public k data = null;
        public Node<k> next = null;
    }

    private Node<k> head = null;
    private int N = 0;

    public int size() {
        return N;
    }

    public k first() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public k second() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        return head.next.data;
    }

    public Node<k> rest() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        return head.next;
    }

    public void add(k data) {
        Node<k> tmp = new Node<>();
        tmp.data = data;
        tmp.next = head;
        head = tmp;
    }

    public k remove() {
        if (head == null) {
            return null;
        }
        Node<k> tmp = head;
        head = head.next;
        return tmp.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
