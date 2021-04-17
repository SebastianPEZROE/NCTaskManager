package mx.edu.j2se.PerezRoque.tasks;

import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * This class works the same way that ArrayTaskList class.
 * It's another form to store tasks in a "list", this list is like
 * an chain of objects, which store the pointer of the task.
 * Its methods can add or remove tasks, show a specific task,
 * count them and even give another LinkedTaskList with tasks in a
 * range of time.
 */
public class LinkedTaskList extends AbstractTaskList{
    public int size = 0;
    private Node head;      //is the begging  node of the list
    private Node node;      //are the rest nodes in the list



    /**
     * This class is used to create a node or box where
     * is going to be stored the pointer of tasks.
     * Also have 'tail' that points the next node,which
     * contains the next stored Task,  so we can know
     * the order of the list.
     */
    private class Node {
        private Node next ;             //is the next node in the list
        private Task taskStoring;       //is the stored task in the node
        public Node (Task taskStoring){
            this.taskStoring = taskStoring;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", taskStoring=" + taskStoring +
                    '}';
        }
    }

    /**
     * Add tasks to list, those tasks are store at the
     * end of the list.
     * @param task is the pointer to be stored
     * @throws NullPointerException if task is null
     */
    @Override
    public void add (Task task)throws NullPointerException{
        if(task ==null){
            throw new NullPointerException(
                    "Task should not be a null value, try another not null please"
            );
        }
        if (head == null){
            head = new Node(task);
        }else if (head.next == null){
            node = new Node(task);
            head.next = node;
        }else {
            Node current_node = head;
            while(current_node.next != null){
                current_node = current_node.next;
            }
            current_node.next = new Node(task);
        }
        size ++;
    }

    /**
     * Remove an specific task of the list and if it is done
     * return true, if the task is not in the list, it return false.
     * @param task is the task to be removed from the list
     * @return a boolean value
     */
    public boolean remove(Task task){
        boolean deleted  = false;
        /*this try is in case the list is empty, so it shows a
        null pointer  error, it would be same that: if (head == null){deleted = false;}else*/
        try {
            if (head.taskStoring == task) {
                //falta eliminar el objeto,solo se esta sacando del linkedlist pero no se esta eliminando
                head = head.next;
                deleted = true;
                size--;
            } else {
                Node current_node = head;
                while (current_node.next != null) {
                    if (current_node.next.taskStoring == task) {
                        //eliminar el objeto
                        current_node.next = current_node.next.next;
                        deleted = true;
                        size--;
                        break;
                    }
                    current_node = current_node.next;
                }
            }
        }catch (Exception e){
            deleted = false;
        }
        return deleted;
    }

    public int size(){
        return size;
    }

    /**
     * return a task according to an index.
     * @param index is the number of the task in the list.
     * @return a task.
     * @throws IndexOutOfBoundsException if the index is negative or bigger than the number of tasks.
     */
    public Task getTask(int index)throws IndexOutOfBoundsException{
        if (index <0 || index >= size){
            throw new IndexOutOfBoundsException(
                    "index should not be negative neither bigger than the number of tasks it contains"
            );
        }
        int count=0;
        Node current_node = head;
        while(count != index){
            current_node = current_node.next;
            count ++;
        }
        return current_node.taskStoring;
    }

    @Override
    public Iterator<Task> iterator(){
        return new itr();
    }

    private class itr implements Iterator<Task>{
        private int cursor = 0;
        private Node next = head;
        private Node last_returned;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public Task next() {
            last_returned = next;
            next = (hasNext() ? next.next : next);
            cursor ++;
            return (cursor <= size() ? last_returned.taskStoring : null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedTaskList tasks = (LinkedTaskList) o;

        if(size()== tasks.size()){
            boolean e;
            Node other = tasks.head;
            for(Node n = head; n != null; n= n.next){
                e= n.taskStoring.equals(other.taskStoring);
                if (!e){
                    return false;
                }
                other = other.next;
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, head);
    }

    @Override
    public String toString() {
        String output = "LinkedTaskList{ size: " +size +", ";
        for(Node n = head; n!= null;n = n.next){
            output = output + n.taskStoring +",";
        }
        return output + "}";
    }

    @Override
    public LinkedTaskList cloning(){
        LinkedTaskList c = new LinkedTaskList();
        for(Node n = head; n != null; n= n.next){
            c.add(n.taskStoring);
        }
        return c;
    }

    private Task[] toArray(){
        Task[] out = new Task[size];
        int i = 0;
        for (Node n = head; n!= null; n= n.next){
            out[i] = n.taskStoring;
            i++;
        }
        return out;
    }

    @Override
    public Stream<Task> getStream(){
        Task [] toStream = toArray();
        return Stream.of(toStream);
    }

}


