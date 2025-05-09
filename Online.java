public class BerkeleySync {
    public static void main(String[] args) {
        int masterTime = 100;
        int[] slaveTimes = {95, 102, 98}; // Clocks of 3 slaves

        // Step 1: Master polls slaves and collects times
        int sum = masterTime;
        for (int t : slaveTimes) sum += t;

        // Step 2: Master calculates average
        int avg = sum / (slaveTimes.length + 1);

        // Step 3: Master calculates adjustments
        int masterAdjust = avg - masterTime;
        int[] slaveAdjusts = new int[slaveTimes.length];
        for (int i = 0; i < slaveTimes.length; i++) {
            slaveAdjusts[i] = avg - slaveTimes[i];
        }

        // Step 4: Master and slaves apply adjustments
        masterTime += masterAdjust;
        for (int i = 0; i < slaveTimes.length; i++) {
            slaveTimes[i] += slaveAdjusts[i];
        }

        // Step 5: Print new times
        System.out.println("Synchronized times:");
        System.out.println("Master: " + masterTime);
        for (int i = 0; i < slaveTimes.length; i++) {
            System.out.println("Slave " + (i+1) + ": " + slaveTimes[i]);
        }
    }
}

public class SimpleBullyElection {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5}; // 5 nodes with IDs 1 to 5
        boolean[] alive = {true, true, true, true, true}; // All nodes are alive

        // Let's say node 5 (the coordinator) fails
        alive[4] = false;
        System.out.println("Node 5 (coordinator) has failed!");

        // Node 3 notices the failure and starts an election
        int starter = 3; // Node 3 starts election
        System.out.println("Node " + starter + " starts election.");

        // Node 3 checks for higher-numbered nodes that are alive
        int newCoordinator = -1;
        for (int i = starter; i < nodes.length; i++) {
            if (alive[i]) {
                newCoordinator = nodes[i];
            }
        }

        if (newCoordinator == -1) {
            // No higher node is alive, so node 3 becomes coordinator
            newCoordinator = starter;
        }

        System.out.println("Node " + newCoordinator + " is elected as the new coordinator.");
    }
}


public class SimpleRingElection {
    public static void main(String[] args) {
        int[] nodes = {0, 1, 2, 3, 4}; // Node IDs
        boolean[] alive = {true, true, true, true, false}; // Node 4 (highest) is down

        int starter = 2; // Node 2 starts election
        int n = nodes.length;
        int current = starter;
        int maxId = nodes[starter];

        System.out.println("Node " + starter + " starts the election.");

        // Pass the message around the ring
        do {
            current = (current + 1) % n;
            if (alive[current]) {
                System.out.println("Message passed to Node " + current);
                if (nodes[current] > maxId) {
                    maxId = nodes[current];
                }
            }
        } while (current != starter);

        System.out.println("Node " + maxId + " is elected as the new coordinator.");
    }
}


public class TokenRing {
    public static void main(String[] args) {
        int n = 5; // Number of processes
        boolean[] wantsToEnter = {false, true, false, true, false}; // Example: process 1 and 3 want to enter CS

        int tokenHolder = 0; // Start with process 0 holding the token

        for (int round = 0; round < 2; round++) { // Two rounds for demonstration
            System.out.println("\nRound " + (round + 1));
            for (int i = 0; i < n; i++) {
                System.out.println("Token at process " + tokenHolder);

                if (wantsToEnter[tokenHolder]) {
                    System.out.println("Process " + tokenHolder + " enters critical section.");
                    // Simulate critical section
                    System.out.println("Process " + tokenHolder + " exits critical section.");
                } else {
                    System.out.println("Process " + tokenHolder + " passes token.");
                }

                // Pass token to next process in the ring
                tokenHolder = (tokenHolder + 1) % n;
            }
        }
    }
}

