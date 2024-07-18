import java.util.Random;

public class gen {
    public static String generate(int lengthInit, int vowelInit, String startLetter, String lengthOp, String vowelOp, Boolean uncommonLet, Boolean addIng){
        Random rand = new Random();
        String[] vowels = {"a","e","i","o","u"};
        String[] allConsonants = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z"};
        String[] reducedConsonants = {"b","c","d","f","g","h","j","k","l","m","n","p","r","s","t"};
        String[] all = {"A","E","I","O","U","B","C","D","F","G","H","J","K","L","M","N","P","Q","R","S","T","V","W","X","Y","Z"};
        String[] reducedAll = {"A","E","I","O","U","B","C","D","F","G","H","J","K","L","M","N","P","R","S","T"};
        String finalWord = "";
        int length = 1;
        int vowelDistance = 1;
        

        if(startLetter=="Any Letter"){
            if(uncommonLet){
                finalWord = randomize(all);
                }else{
                finalWord = randomize(reducedAll);
                }
        }else if(startLetter == "Any Consonant"){
            if(uncommonLet){
            finalWord = randomize(allConsonants);
            }else{
            finalWord = randomize(reducedConsonants);
            }
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
        if(length<=1){
            length=3;
        }else if(length>20){
            length = 20;
        }

        //System.out.println(length);


        //inserts random letters until the length is met
        for(@SuppressWarnings("unused")
        int i = 0; finalWord.length()<length;){
            for(int j = 1; j<=vowelDistance&&finalWord.length()<length; j++){

                if(uncommonLet){
                finalWord = finalWord+randomize(allConsonants);
                }else{
                    finalWord = finalWord+randomize(reducedConsonants);
                }

                //inserts a vowel after voweldistance is met (for example, if voweldistance is 2, only add a vowel every 2 letters)
                if(j==vowelDistance&&finalWord.length()<length){
                    finalWord = finalWord+randomize(vowels);
                }
            }
        }
        if(addIng){
            if (finalWord.endsWith("e")) {
                //fern you are a genius because idk what this is doing
                StringBuffer stringBuffer = new StringBuffer(finalWord);
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                finalWord = (stringBuffer.toString());
            }
            return finalWord+"ing";
            }else{
            return finalWord;
            }
    }

    public static String randomize(String[] array){

        //gens random number. returns variable in array with same index
        Random rand = new Random();
        int resultIndex = rand.nextInt(array.length);
        if(resultIndex==0){
            resultIndex = 1;
        }
        return array[resultIndex];

    }
}