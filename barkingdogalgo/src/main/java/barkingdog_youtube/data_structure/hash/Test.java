package barkingdog_youtube.data_structure.hash;

public class Test {

    public static void main(String[] args) {
        ChainingHash chainingHash = new ChainingHash();

        chainingHash.insert("n1", 1);
        chainingHash.insert("n2", 2);
        chainingHash.insert("n3", 3);
        chainingHash.insert("n1", 4);
        chainingHash.erase("n2");

//        chainingHash.insert("key147", 147);
//        chainingHash.insert("key89234", 89234);

        System.out.println(chainingHash.find("n1"));
        System.out.println(chainingHash.find("n2"));
        System.out.println(chainingHash.find("n3"));
        System.out.println(chainingHash.find("n4"));
        System.out.println();

//        System.out.println(chainingHash.find("key147"));
//        System.out.println(chainingHash.find("key89234"));
//        System.out.println(chainingHash.isHashSame("key147", "key89234"));

        System.out.println();

        OpenAddressing openAddressing = new OpenAddressing();

        openAddressing.insert("n1", 1);
        openAddressing.insert("n2", 2);
        openAddressing.insert("n3", 3);
        openAddressing.insert("n1", 4);
        openAddressing.erase("n2");

        System.out.println(chainingHash.find("n1"));
        System.out.println(chainingHash.find("n2"));
        System.out.println(chainingHash.find("n3"));
        System.out.println(chainingHash.find("n4"));
    }
}
