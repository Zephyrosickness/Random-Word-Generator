import java.util.Random;
public class gen {
    public static String generate(int lengthInit, int vowelInit, String startLetter, String lengthOp, String vowelOp){
        Random rand = new Random();
        String[] vowels = {"a","e","i","o","u"};
        String[] consonants = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z"};
        String[] all = {"A","E","I","O","U","B","C","D","F","G","H","J","K","L","M","N","P","Q","R","S","T","V","W","X","Y","Z"};
        String finalWord = "";
        int length = 1;
        int vowelDistance = 1;

        if(startLetter=="Any Letter"){
            finalWord = randomize(all);
        }else if(startLetter == "Any Consonant"){
            finalWord = randomize(consonants);
        }else if(startLetter == "Any Vowel"){
            finalWord = randomize(vowels);
        }else{
            finalWord = startLetter;
        }


        switch(vowelOp){
            case "Any":
                vowelDistance = rand.nextInt(4);
                break;
            case "<":
                vowelDistance = rand.nextInt(vowelInit);
                break;
            case "=":
                vowelDistance = vowelInit;
                break;
            default:
                System.out.println("something fucked up with the vowelop lil bro. vowelop: "+vowelOp);
        }
        if(vowelDistance == 0){
            vowelDistance = 1;
        }

        switch(lengthOp){
            case "Any":
                length = rand.nextInt(13);
                break;
            case "<":
                length = rand.nextInt(lengthInit);
                break;
            case "=":
                length = lengthInit;
                break;
            default:
                System.out.println("something fucked up with the lengthop lil bro. lengthop: "+lengthOp);
        }

        System.out.println(length);


        //inserts random letters until the length is met
        for(int i = 0; finalWord.length()<length;){
            for(int j = 1; j<=vowelDistance&&finalWord.length()<length; j++){
                finalWord = finalWord+randomize(consonants);

                //inserts a vowel after voweldistance is met (for example, if voweldistance is 2, only add a vowel every 2 letters)
                if(j==vowelDistance&&finalWord.length()<length){
                    finalWord = finalWord+randomize(vowels);
                }
            }
        }
        return finalWord;
    }

    public static String randomize(String[] array){

        Random rand = new Random();
        int resultIndex = rand.nextInt(array.length);
        if(resultIndex==0){
            resultIndex = 1;
        }
        return array[resultIndex];

    }
}
