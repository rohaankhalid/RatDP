import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class RatFeeder {
    private Queue<Rat> healthyRatsQueue = new LinkedList<>();
    private PriorityQueue<Rat> sickRatsQueue = new PriorityQueue<>(Comparator.comparing(r -> r.name));

    public void addRat(Rat rat) {
        if(rat.isSickOrInjured) {
            sickRatsQueue.add(rat);
        } else {
            healthyRatsQueue.add(rat);
        }
    }

    public void feedRats() {
        // tempRats stores previously sick/injured healthy rats, which after being fed are healthy now
        List<Rat> tempRats = new ArrayList<>();

        // first feed all sick/injured rats
        int sickRatsCount = sickRatsQueue.size();
        for (int i = 0; i < sickRatsCount; i++) {
            Rat rat = sickRatsQueue.poll();
            System.out.println("Feeding: " + rat);
            // rat gets healthy after being fed
            rat.setHealthStatus(false);
            // add to a temporary list
            tempRats.add(rat);
        }

        // next feed all healthy rats
        int healthyRatsCount = healthyRatsQueue.size();
        for (int i = 0; i < healthyRatsCount; i++) {
            Rat rat = healthyRatsQueue.poll();
            System.out.println("Feeding: " + rat);
            // once fed, healthy rat goes to the back of the queue
            healthyRatsQueue.add(rat);
        }

        //add the formerly sick rats to the healthy queue after all current rats are fed
        healthyRatsQueue.addAll(tempRats);
    }

    public static void main(String[] args) {
        RatFeeder feeder = new RatFeeder();
        feeder.addRat(new Rat("Rat1", false));
        feeder.addRat(new Rat("Rat2", true));
        feeder.addRat(new Rat("Rat3", false));
        feeder.addRat(new Rat("Rat4", true));

        feeder.feedRats();
        System.out.println("Next round of feeding:");
        feeder.feedRats();
        System.out.println("Next round of feeding:");
        feeder.feedRats();
    }

}
