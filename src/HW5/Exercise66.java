package HW5;

public class Exercise66 {

    public static boolean canSpell(String word, String tiles) {
        boolean valid = false;

        for(int i = 0; i < word.length(); i++){
            valid = false;

            for(int j = 0; j < tiles.length(); j++){

                if (word.charAt(i) == tiles.charAt(j)) {
                    valid = true;
                    tiles = tiles.substring(0, j) + tiles.substring(j + 1);
                    break;
                }
            }

            if (valid == false){
                return valid;
            }

        }
        return valid;
    }

    public static void main(String [] args) {
        System.out.println(canSpell("boot", "axobasrto"));
        System.out.println(canSpell("balloon","jwjokbahjjbhllohjhjgon"));
        System.out.println(!canSpell("hippo", "haxobapsrito"));
        System.out.println(!canSpell("hat", "hwidjakw"));
        System.out.println(!canSpell("chair", "osodeowsx"));

        // Student: add more test cases
    }
}
