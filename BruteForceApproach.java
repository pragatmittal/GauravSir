import java.util.*;

/**
 * This program determines the schedule for taking medicines based on their frequency and priority.
 * It uses a brute-force approach by generating all possible intake times, sorting them,
 * and then picking the first 'k' required doses.
 *
 * The priority is determined by the order of input: the first medicine has the highest priority.
 */
public class BruteForceApproach {

    // Represents a medicine with its properties
    static class Medicine {
        String name;
        int frequency; // Time interval between doses
        int priority;  // Lower number means higher priority (0 is highest)

        Medicine(String name, int frequency, int priority) {
            this.name = name;
            this.frequency = frequency;
            this.priority = priority;
        }
    }

    // Represents a specific instance of taking a medicine at a certain time
    static class MedicineTime {
        int time;
        String medicineName;
        int priority;

        MedicineTime(int time, String medicineName, int priority) {
            this.time = time;
            this.medicineName = medicineName;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(); // Number of different medications
            int k = sc.nextInt(); // Total number of medicines to take

            List<Medicine> medicines = new ArrayList<>();

            // Read all medicines and assign priority based on input order
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                int frequency = sc.nextInt();
                medicines.add(new Medicine(name, frequency, i)); // Priority is the index 'i'
            }

            // STEP 1: Generate all possible medicine intake times up to a reasonable limit
            List<MedicineTime> allMedicineTimes = new ArrayList<>();
            for (Medicine med : medicines) {
                // A safe upper bound to ensure we generate at least k events
                int maxTime = k * 10000; 
                for (int time = med.frequency; time <= maxTime; time += med.frequency) {
                    allMedicineTimes.add(new MedicineTime(time, med.name, med.priority));
                }
            }

            // STEP 2: Sort all generated events
            // The primary sort key is time (ascending).
            // The secondary sort key is priority (ascending, so 0 comes before 1).
            Collections.sort(allMedicineTimes, new Comparator<MedicineTime>() {
                @Override
                public int compare(MedicineTime a, MedicineTime b) {
                    if (a.time != b.time) {
                        return Integer.compare(a.time, b.time); // Earlier time first
                    }
                    return Integer.compare(a.priority, b.priority); // Higher priority (lower number) first
                }
            });

            // STEP 3: Take the first k medicines from the sorted list and print them
            for (int i = 0; i < k && i < allMedicineTimes.size(); i++) {
                MedicineTime mt = allMedicineTimes.get(i);
                System.out.println(mt.time + " " + mt.medicineName);
            }
        }

        sc.close();
    }
}

/**
 * This class demonstrates how the brute-force algorithm works with a fixed example.
 * To run this demonstration, execute this class's main method.
 */
class BruteForceDemo {

    public static void demonstrate() {
        System.out.println("=== BRUTE-FORCE APPROACH DEMONSTRATION ===");
        System.out.println();

        // Sample Input: n=2 medicines, k=5 doses to take
        System.out.println("Input:");
        System.out.println("n=2, k=5");
        System.out.println("Acetaminophen 20 (priority 0)");
        System.out.println("Loratadine 30 (priority 1)");
        System.out.println();

        // Step 1: Generate all possible times for each medicine
        System.out.println("STEP 1: Generate all medicine times");
        List<String> acetaminophenTimes = Arrays.asList("20", "40", "60", "80", "100", "120", "...");
        List<String> loratadineTimes = Arrays.asList("30", "60", "90", "120", "150", "...");
        System.out.println("Acetaminophen times: " + acetaminophenTimes);
        System.out.println("Loratadine times:    " + loratadineTimes);
        System.out.println();

        // Step 2: Combine all events into a single list
        System.out.println("STEP 2: Combine all times with their priorities");
        List<String> combined = Arrays.asList(
            "20 Acetaminophen(p0)", "30 Loratadine(p1)", "40 Acetaminophen(p0)",
            "60 Acetaminophen(p0)", "60 Loratadine(p1)", "80 Acetaminophen(p0)",
            "90 Loratadine(p1)", "100 Acetaminophen(p0)"
        );
        System.out.println("Combined events: " + combined);
        System.out.println();

        // Step 3: Sort the combined list
        System.out.println("STEP 3: Sort by time, then by priority");
        System.out.println("Sorted: [20 A(p0), 30 L(p1), 40 A(p0), 60 A(p0), 60 L(p1), 80 A(p0), ...]");
        System.out.println("Note: At time 60, Acetaminophen(p0) comes before Loratadine(p1) due to higher priority.");
        System.out.println();

        // Step 4: Take the first k=5 results
        System.out.println("STEP 4: Take the first k=5 medicines from the sorted list");
        System.out.println("Final Output:");
        System.out.println("20 Acetaminophen");
        System.out.println("30 Loratadine");
        System.out.println("40 Acetaminophen");
        System.out.println("60 Acetaminophen");
        System.out.println("60 Loratadine");
    }

    public static void main(String[] args) {
        demonstrate();
    }
}