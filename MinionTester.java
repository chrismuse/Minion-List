import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
public class MinionTester {
    public static void main(String[] args) {
        MinionList forward = new MinionList();
        forward.enqueue(new Minion("bob", 10.2, 7));
        forward.enqueue(new Minion("joe", 4.2, 2));
        forward.enqueue(new Minion("barl", 87.2, 3));
        forward.enqueue(new Minion("kane", 1.2, 34));
        forward.enqueue(new Minion("shicke", 09.2, 4));
        forward.enqueue(new Minion("quark", 33.2, 12));
        forward.enqueue(new Minion("link", 10.2, 54));
        List<Minion> forwardD = new ArrayList<>();
        //forwardD.addAll(forward);
        forwardD.add(new Minion("bob", 10.2, 7));
        forwardD.add(new Minion("joe", 4.2, 2));
        forwardD.add(new Minion("barl", 87.2, 3));
        forwardD.add(new Minion("kane", 1.2, 34));
        forwardD.add(new Minion("shicke", 09.2, 4));
        forwardD.add(new Minion("quark", 33.2, 12));
        forwardD.add(new Minion("link", 10.2, 54));
        System.out.println("forward list");
        System.out.println(forward);
        System.out.println("reverse list");
        System.out.println(forward.reverse());
        System.out.println("List sorted by height");
        Minion m = new Minion("link", 10.2, 54);
        Comparator<Minion> hei = m.compareByHeight();
        Comparator<Minion> iQ = m.compareByIQ();
        Collections.sort(forwardD, hei);
        System.out.println(forwardD);
        System.out.println("List sorted by IQ");
        Collections.sort(forwardD, iQ);
        System.out.println(forwardD);
        System.out.println("\n\n\n\n\n\n");

        MinionList stack = new MinionList();
        stack.push(new Minion("bob", 10.2, 7));
        stack.push(new Minion("joe", 4.2, 2));
        stack.push(new Minion("barl", 87.2, 3));
        stack.push(new Minion("kane", 1.2, 34));
        stack.push(new Minion("shicke", 09.2, 4));
        stack.push(new Minion("quark", 33.2, 12));
        stack.push(new Minion("link", 10.2, 54));

        System.out.println("STACK (LIFO):\n");
        System.out.println(stack);
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());


        MinionList queue = new MinionList();
        queue.enqueue(new Minion("bob", 10.2, 7));
        queue.enqueue(new Minion("joe", 4.2, 2));
        queue.enqueue(new Minion("barl", 87.2, 3));
        queue.enqueue(new Minion("kane", 1.2, 34));
        queue.enqueue(new Minion("shicke", 09.2, 4));
        queue.enqueue(new Minion("quark", 33.2, 12));
        queue.enqueue(new Minion("link", 10.2, 54));

        System.out.println("QUEUE (FIFO):\n");
        System.out.println(queue);
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());

        System.out.println(); System.out.println(); System.out.println();

        System.out.println("Super test");
        MinionList test = new MinionList();
        test.push(new Minion("bob", 10.2, 7));
        test.push(new Minion("joe", 4.2, 2));
        test.enqueue(new Minion("barl", 87.2, 3));
        test.push(new Minion("kane", 1.2, 34));
        test.enqueue(new Minion("shicke", 09.2, 4));
        test.enqueue(new Minion("quark", 33.2, 12));
        test.push(new Minion("link", 10.2, 54));
        System.out.println();
        System.out.println(test);
        System.out.println();
        System.out.println("dequeue: " + test.dequeue());
        System.out.println("pop: " + test.pop());
        System.out.println("dequeue: " + test.dequeue());
        System.out.println("pop: " + test.pop());
        System.out.println("dequeue: " + test.dequeue());


        System.out.println("for each test");
        MinionList tester = new MinionList();
        tester.push(new Minion("bob", 10.2, 7));
        tester.push(new Minion("joe", 4.2, 2));
        tester.enqueue(new Minion("barl", 87.2, 3));
        tester.push(new Minion("kane", 1.2, 34));
        tester.enqueue(new Minion("shicke", 09.2, 4));
        tester.enqueue(new Minion("quark", 33.2, 12));
        tester.push(new Minion("link", 10.2, 54));

        for(Minion min: tester) {
            System.out.println(min);
        }

        System.out.println(tester.get(0));
        System.out.println(tester.get(3));
        MinionList empty = new MinionList();
        System.out.println(empty.reverse());





    }
}