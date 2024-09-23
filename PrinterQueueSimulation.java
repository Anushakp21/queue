package queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class PrintJob implements Comparable<PrintJob> {
    private String jobName;
    private int priority;

    public PrintJob(String jobName, int priority) {
        this.jobName = jobName;
        this.priority = priority;
    }

    public String getJobName() {
        return jobName;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(PrintJob other) {
        return other.priority - this.priority; // Higher priority first
    }

    @Override
    public String toString() {
        return "Print Job: " + jobName + " (Priority: " + priority + ")";
    }
}

class PrinterQueue {
    private PriorityQueue<PrintJob> queue;

    public PrinterQueue() {
        queue = new PriorityQueue<>();
    }

    public void addJob(PrintJob job) {
        queue.offer(job);
        System.out.println("Added: " + job);
    }

    public void processJob() {
        if (queue.isEmpty()) {
            System.out.println("No jobs to process.");
        } else {
            PrintJob job = queue.poll();
            System.out.println("Processing: " + job);
        }
    }

    public boolean hasJobs() {
        return !queue.isEmpty();
    }
}

public class PrinterQueueSimulation {

    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();

        printerQueue.addJob(new PrintJob("Document1", 2));
        printerQueue.addJob(new PrintJob("Document2", 1));
        printerQueue.addJob(new PrintJob("Document3", 3));

        System.out.println("\nProcessing jobs in order of priority:");
        while (printerQueue.hasJobs()) {
            printerQueue.processJob();
        }
    }
}

