import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Albert Einstein", new Contact("Albert Einstein", "+1 908 628 8502"));
        contacts.put("Marie Curie", new Contact("Marie Curie", "+1 702 526 8642"));
        contacts.put("Galileo Galilei", new Contact("Galileo Galilei", "+1 546 826 6293"));
        contacts.put("Charles Darwin", new Contact("Charles Darwin", "+1 853 747 6008"));
 
        // Step 5: look up a contact 
        System.out.println("Welcome to the Contact Manager Search!");
        System.out.println();
        System.out.println("Looking For Ada...");
        System.out.println("Ada found!");
        System.out.println();
        String examplename = "Ada Lovelace";
        Contact foundcontact = contacts.get(examplename);
        if (foundcontact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(foundcontact);
        }
        System.out.println();

        System.out.println("Looking For Oppenheimer....");
        String examplename2 = "Julius Robert Oppenheimer";
        Contact foundcontact2 = contacts.get(examplename2);
        if (foundcontact2 == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(foundcontact2);
        }
        System.out.println();

        // Step 6: print sorted list 
        System.out.println("=== All Contacts ===");
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        for (Contact c : sorted) {
            System.out.println(c);
        }
    } 
}